//===----------------------------------------------------------------------===//
//
// This source file is part of the Swift.org open source project
//
// Copyright (c) 2024 Apple Inc. and the Swift.org project authors
// Licensed under Apache License v2.0
//
// See LICENSE.txt for license information
// See CONTRIBUTORS.txt for the list of Swift.org project authors
//
// SPDX-License-Identifier: Apache-2.0
//
//===----------------------------------------------------------------------===//

import Foundation
import ArgumentParser
import SwiftJavaLib
import JavaKit
import JavaKitJar
import SwiftJavaLib
import JavaKitConfigurationShared

extension SwiftJava {
  mutating func generateWrappers(
    config: Configuration,
    classpath: String,
    dependentConfigs: [(String, Configuration)],
    environment: JNIEnvironment
  ) throws {
    let translator = JavaTranslator(
      swiftModuleName: effectiveSwiftModule,
      environment: environment,
      translateAsClass: true
    )

    // Keep track of all of the Java classes that will have
    // Swift-native implementations.
    translator.swiftNativeImplementations = Set(swiftNativeImplementation)

    // Note all of the dependent configurations.
    for (swiftModuleName, dependentConfig) in dependentConfigs {
      translator.addConfiguration(
        dependentConfig,
        forSwiftModule: swiftModuleName
      )
    }

    // Add the configuration for this module.
    translator.addConfiguration(config, forSwiftModule: effectiveSwiftModule)

    // Load all of the explicitly-requested classes.
    let classLoader = try JavaClass<ClassLoader>(environment: environment)
      .getSystemClassLoader()!
    var javaClasses: [JavaClass<JavaObject>] = []
    for (javaClassName, _) in config.classes ?? [:] {
      guard let javaClass = try classLoader.loadClass(javaClassName) else {
        print("warning: could not find Java class '\(javaClassName)'")
        continue
      }

      // Add this class to the list of classes we'll translate.
      javaClasses.append(javaClass)
    }

    // Find all of the nested classes for each class, adding them to the list
    // of classes to be translated if they were already specified.
    var allClassesToVisit = javaClasses
    var currentClassIndex: Int = 0
    while currentClassIndex < allClassesToVisit.count {
      defer {
        currentClassIndex += 1
      }

      // The current class we're in.
      let currentClass = allClassesToVisit[currentClassIndex]
      guard let currentSwiftName = translator.translatedClasses[currentClass.getName()]?.swiftType else {
        continue
      }

      // Find all of the nested classes that weren't explicitly translated
      // already.
      let nestedClasses: [JavaClass<JavaObject>] = currentClass.getClasses().compactMap { nestedClass in
        guard let nestedClass else { return nil }

        // If this is a local class, we're done.
        let javaClassName = nestedClass.getName()
        if javaClassName.isLocalJavaClass {
          return nil
        }

        // If this class has been explicitly mentioned, we're done.
        if translator.translatedClasses[javaClassName] != nil {
          return nil
        }

        // Record this as a translated class.
        let swiftUnqualifiedName = javaClassName.javaClassNameToCanonicalName
          .defaultSwiftNameForJavaClass


        let swiftName = "\(currentSwiftName).\(swiftUnqualifiedName)"
        translator.translatedClasses[javaClassName] = (swiftName, nil)
        return nestedClass
      }

      // If there were no new nested classes, there's nothing to do.
      if nestedClasses.isEmpty {
        continue
      }

      // Record all of the nested classes that we will visit.
      translator.nestedClasses[currentClass.getName()] = nestedClasses
      allClassesToVisit.append(contentsOf: nestedClasses)
    }

    // Validate configurations before writing any files
    try translator.validateClassConfiguration()

    // Translate all of the Java classes into Swift classes.
    for javaClass in javaClasses {
      translator.startNewFile()
      let swiftClassDecls = try translator.translateClass(javaClass)
      let importDecls = translator.getImportDecls()

      let swiftFileText = """
                          // Auto-generated by Java-to-Swift wrapper generator.
                          \(importDecls.map { $0.description }.joined())
                          \(swiftClassDecls.map { $0.description }.joined(separator: "\n"))

                          """

      let swiftFileName = try! translator.getSwiftTypeName(javaClass, preferValueTypes: false)
        .swiftName.replacing(".", with: "+") + ".swift"
      try writeContents(
        swiftFileText,
        to: swiftFileName,
        description: "Java class '\(javaClass.getName())' translation"
      )
    }
  }
}
