// Auto-generated by Java-to-Swift wrapper generator.
import JavaKit
import JavaRuntime

@JavaInterface("java.nio.file.Path")
public struct Path {
  @JavaMethod
  public func getName(_ arg0: Int32) -> Path!

  @JavaMethod
  public func equals(_ arg0: JavaObject?) -> Bool

  @JavaMethod
  public func toString() -> String

  @JavaMethod
  public func hashCode() -> Int32

  @JavaMethod
  public func compareTo(_ arg0: Path?) -> Int32

  @JavaMethod
  public func compareTo(_ arg0: JavaObject?) -> Int32

  @JavaMethod
  public func startsWith(_ arg0: String) -> Bool

  @JavaMethod
  public func startsWith(_ arg0: Path?) -> Bool

  @JavaMethod
  public func endsWith(_ arg0: String) -> Bool

  @JavaMethod
  public func endsWith(_ arg0: Path?) -> Bool

  @JavaMethod
  public func isAbsolute() -> Bool

  @JavaMethod
  public func resolve(_ arg0: String, _ arg1: [String]) -> Path!

  @JavaMethod
  public func resolve(_ arg0: Path?, _ arg1: [Path?]) -> Path!

  @JavaMethod
  public func resolve(_ arg0: String) -> Path!

  @JavaMethod
  public func resolve(_ arg0: Path?) -> Path!

  @JavaMethod
  public func getParent() -> Path!

  @JavaMethod
  public func getRoot() -> Path!

  @JavaMethod
  public func toFile() -> File!

  @JavaMethod
  public func getFileName() -> Path!

  @JavaMethod
  public func normalize() -> Path!

  @JavaMethod
  public func relativize(_ arg0: Path?) -> Path!

  @JavaMethod
  public func getNameCount() -> Int32

  @JavaMethod
  public func toAbsolutePath() -> Path!

  @JavaMethod
  public func resolveSibling(_ arg0: String) -> Path!

  @JavaMethod
  public func resolveSibling(_ arg0: Path?) -> Path!

  @JavaMethod
  public func subpath(_ arg0: Int32, _ arg1: Int32) -> Path!
}
extension JavaClass<Path> {
  @JavaStaticMethod
  public func of(_ arg0: String, _ arg1: [String]) -> Path!
}
