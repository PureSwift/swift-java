//===----------------------------------------------------------------------===//
//
// This source file is part of the Swift.org open source project
//
// Copyright (c) 2024 Apple Inc. and the Swift.org project authors
// Licensed under Apache License v2.0
//
// See LICENSE.txt for license information
//
// SPDX-License-Identifier: Apache-2.0
//
//===----------------------------------------------------------------------===//

package org.example.swift;

import com.example.swift.generated.JavaKitExample;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.util.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;

/**
 * Generated by {@code jextract-swift}. // TODO: will be... :-)
 */
public class ManualJavaKitExample {

    ManualJavaKitExample() {
        // Should not be called directly
    }

    static final String DYLIB_NAME = "JavaKitExample";
    static final Arena LIBRARY_ARENA = Arena.ofAuto();
    static final boolean TRACE_DOWNCALLS = Boolean.getBoolean("jextract.trace.downcalls");

    static void traceDowncall(Object... args) {
        var ex = new RuntimeException();

        String traceArgs = Arrays.stream(args)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.printf("[java][%s:%d] %s(%s)\n",
                ex.getStackTrace()[1].getFileName(),
                ex.getStackTrace()[1].getLineNumber(),
                ex.getStackTrace()[1].getMethodName(),
                traceArgs);
    }

    static void trace(Object... args) {
        var ex = new RuntimeException();

        String traceArgs = Arrays.stream(args)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.printf("[java][%s:%d] %s: %s\n",
                ex.getStackTrace()[1].getFileName(),
                ex.getStackTrace()[1].getLineNumber(),
                ex.getStackTrace()[1].getMethodName(),
                traceArgs);
    }

    static MemorySegment findOrThrow(String symbol) {
        return SYMBOL_LOOKUP.find(symbol)
                .orElseThrow(() -> new UnsatisfiedLinkError("unresolved symbol: %s".formatted(symbol)));
    }

    static MethodHandle upcallHandle(Class<?> fi, String name, FunctionDescriptor fdesc) {
        try {
            return MethodHandles.lookup().findVirtual(fi, name, fdesc.toMethodType());
        } catch (ReflectiveOperationException ex) {
            throw new AssertionError(ex);
        }
    }

    static MemoryLayout align(MemoryLayout layout, long align) {
        return switch (layout) {
            case PaddingLayout p -> p;
            case ValueLayout v -> v.withByteAlignment(align);
            case GroupLayout g -> {
                MemoryLayout[] alignedMembers = g.memberLayouts().stream()
                        .map(m -> align(m, align)).toArray(MemoryLayout[]::new);
                yield g instanceof StructLayout ?
                        MemoryLayout.structLayout(alignedMembers) : MemoryLayout.unionLayout(alignedMembers);
            }
            case SequenceLayout s -> MemoryLayout.sequenceLayout(s.elementCount(), align(s.elementLayout(), align));
        };
    }

    static final SymbolLookup SYMBOL_LOOKUP =
            SymbolLookup.libraryLookup(System.mapLibraryName(DYLIB_NAME), LIBRARY_ARENA)
                    .or(SymbolLookup.loaderLookup())
                    .or(Linker.nativeLinker().defaultLookup());

    // TODO: rather than the C ones offer the Swift mappings
    public static final ValueLayout.OfBoolean C_BOOL = ValueLayout.JAVA_BOOLEAN;
    public static final ValueLayout.OfByte C_CHAR = ValueLayout.JAVA_BYTE;
    public static final ValueLayout.OfShort C_SHORT = ValueLayout.JAVA_SHORT;
    public static final ValueLayout.OfInt C_INT = ValueLayout.JAVA_INT;
    public static final ValueLayout.OfLong C_LONG_LONG = ValueLayout.JAVA_LONG;
    public static final ValueLayout.OfFloat C_FLOAT = ValueLayout.JAVA_FLOAT;
    public static final ValueLayout.OfDouble C_DOUBLE = ValueLayout.JAVA_DOUBLE;
    public static final AddressLayout C_POINTER = ValueLayout.ADDRESS
            .withTargetLayout(MemoryLayout.sequenceLayout(java.lang.Long.MAX_VALUE, JAVA_BYTE));
    public static final ValueLayout.OfLong C_LONG = ValueLayout.JAVA_LONG;

    public static final ValueLayout.OfBoolean SWIFT_BOOL = ValueLayout.JAVA_BOOLEAN;
    public static final ValueLayout.OfByte SWIFT_INT8 = ValueLayout.JAVA_BYTE;
    public static final ValueLayout.OfChar SWIFT_UINT16 = ValueLayout.JAVA_CHAR;
    public static final ValueLayout.OfShort SWIFT_INT16 = ValueLayout.JAVA_SHORT;
    public static final ValueLayout.OfInt SWIFT_INT32 = ValueLayout.JAVA_INT;
    public static final ValueLayout.OfLong SWIFT_INT64 = ValueLayout.JAVA_LONG;
    public static final ValueLayout.OfFloat SWIFT_FLOAT = ValueLayout.JAVA_FLOAT;
    public static final ValueLayout.OfDouble SWIFT_DOUBLE = ValueLayout.JAVA_DOUBLE;
    public static final AddressLayout SWIFT_POINTER = ValueLayout.ADDRESS;
    // On the platform this was generated on, Int was Int64
    public static final SequenceLayout SWIFT_BYTE_ARRAY =
            MemoryLayout.sequenceLayout(8, JAVA_BYTE);
    public static final ValueLayout.OfLong SWIFT_INT = SWIFT_INT64;
    public static final ValueLayout.OfLong SWIFT_UINT = SWIFT_INT64;
    public static final AddressLayout SWIFT_TYPE_METADATA_PTR = SWIFT_POINTER;

    // -----------------------------------------------------------------------------------------------------------------
    // helloWorld()

    // sil [ossa] @$s14JavaKitExample10helloWorldyyF : $@convention(thin) () -> () {
    private static class helloWorld {
        public static final FunctionDescriptor DESC = FunctionDescriptor.ofVoid();

        public static final MemorySegment ADDR = ManualJavaKitExample.findOrThrow("$s14JavaKitExample10helloWorldyyF");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang = swift:
     * public func useMySwiftSlice(slice: MySwiftLibrary.MySwiftSlice)
     *}
     */
    public static FunctionDescriptor helloWorld$descriptor() {
        return helloWorld.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang = swift:
     * public func useMySwiftSlice(slice: MySwiftLibrary.MySwiftSlice)
     *}
     */
    public static MethodHandle helloWorld$handle() {
        return helloWorld.HANDLE;
    }

    /**
     * Address for:
     * {@snippet lang = swift:
     * public func useMySwiftSlice(slice: MySwiftLibrary.MySwiftSlice)
     *}
     */
    public static MemorySegment helloWorld$address() {
        return helloWorld.ADDR;
    }

    /**
     * {@snippet lang = swift:
     * public func useMySwiftSlice(slice: MySwiftLibrary.MySwiftSlice)
     *}
     */
    public static void helloWorld() {
        var mh$ = helloWorld.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall();
            }
            mh$.invokeExact();
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    // ==== --------------------------------------------------
    // 0000000000031934 T JavaKitExample.globalCallJavaCallback(callMe: () -> ()) -> ()
    // 0000000000031934 T _$s14JavaKitExample010globalCallA8Callback6callMeyyyXE_tF

    private static class globalCallJavaCallback {
        public static final FunctionDescriptor DESC = FunctionDescriptor.ofVoid(
                ADDRESS // Runnable / () -> ()
        );

        public static final MemorySegment ADDR = ManualJavaKitExample.findOrThrow("$s14JavaKitExample010globalCallA8Callback6callMeyyyXE_tF");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
    }


    public static void globalCallJavaCallback(Runnable callMe) {
        var mh$ = globalCallJavaCallback.HANDLE;

        try {
             FunctionDescriptor callMe_run_desc = FunctionDescriptor.ofVoid(
                     // replicate signature of run()
             );
             MethodHandle callMe_run_handle = MethodHandles.lookup()
                     .findVirtual(Runnable.class,
                             "run",
                             callMe_run_desc.toMethodType()
                     );
            callMe_run_handle = callMe_run_handle.bindTo(callMe); // set the first parameter to the Runnable as the "this" of the callback pretty much

            try (Arena arena = Arena.ofConfined()) {
                Linker linker = Linker.nativeLinker(); // the () -> () is not escaping, we can destroy along with the confined arena
                MemorySegment runFunc = linker.upcallStub(callMe_run_handle, callMe_run_desc, arena);
                mh$.invokeExact(runFunc);
            }

        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (Throwable e) {
            throw new AssertionError(e);
        }
    }


    // -----------------------------------------------------------------------------------------------------------------
    // FIXME: this must move into SwiftKit and call _typeByName with a Swift.String

    /// 00000000000255a4 T _$s14JavaKitExample33swiftkit_getTypeByStringByteArrayyypXpSgSPys5UInt8VGF
    /// 00000000000255a4 T JavaKitExample.swiftkit_getTypeByStringByteArray(Swift.UnsafePointer<Swift.UInt8>) -> Any.Type?
    private static class swiftkit_getTypeByStringByteArray {
        public static final FunctionDescriptor DESC = FunctionDescriptor.of(
                /* -> */ ValueLayout.ADDRESS,
                ValueLayout.ADDRESS
        );

        public static final MemorySegment ADDR = ManualJavaKitExample.findOrThrow("$s14JavaKitExample33swiftkit_getTypeByStringByteArrayyypXpSgSPys5UInt8VGF");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
    }

    public static FunctionDescriptor swiftkit_getTypeByStringByteArray$descriptor() {
        return swiftkit_getTypeByStringByteArray.DESC;
    }

    public static MethodHandle swiftkit_getTypeByStringByteArray$handle() {
        return swiftkit_getTypeByStringByteArray.HANDLE;
    }

    public static MemorySegment swiftkit_getTypeByStringByteArray$address() {
        return swiftkit_getTypeByStringByteArray.ADDR;
    }

    public static MemorySegment swiftkit_getTypeByStringByteArray(String mangledName) {
        var mh$ = swiftkit_getTypeByStringByteArray.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("swiftkit_getTypeByStringByteArray", mangledName);
            }
            try (Arena arena = Arena.ofConfined()) {
                MemorySegment mangledNameMS = arena.allocateFrom(mangledName);
                return (MemorySegment) mh$.invokeExact(mangledNameMS);
            }
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

//    // -----------------------------------------------------------------------------------------------------------------
//    // useMySwiftSlice_getLen(slice: MySwiftSlice)
//
//
//    // JavaKitExample.useMySwiftSlice_getLen(slice: JavaKitExample.MySwiftSlice) -> Swift.Int
//    private static class useMySwiftSlice_getLen {
//        public static final FunctionDescriptor DESC = FunctionDescriptor.of(
//                /* -> */ JavaKitExample.SWIFT_INT,
//                JavaKitExample.SWIFT_POINTER // FIXME: not: MySwiftSlice.layout()
//        );
//
////         public static final MemorySegment ADDR = JavaKitExample.findOrThrow("$s14JavaKitExample22useMySwiftSlice_getLen5sliceSiAA0efG0V_tF");
//
//        // with inout
//        public static final MemorySegment ADDR = JavaKitExample.findOrThrow("$s14JavaKitExample22useMySwiftSlice_getLen5sliceSiAA0efG0Vz_tF");
//
//        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
//    }
//
//    /**
//     * Function descriptor for:
//     * {@snippet lang=swift :
//     * public func useMySwiftSlice(slice: MySwiftLibrary.MySwiftSlice)
//     * }
//     */
//    public static FunctionDescriptor useMySwiftSlice$descriptor() {
//        return useMySwiftSlice_getLen.DESC;
//    }
//
//    /**
//     * Downcall method handle for:
//     * {@snippet lang=swift :
//     * public func useMySwiftSlice(slice: MySwiftLibrary.MySwiftSlice)
//     * }
//     */
//    public static MethodHandle useMySwiftSlice$handle() {
//        return useMySwiftSlice_getLen.HANDLE;
//    }
//
//    /**
//     * Address for:
//     * {@snippet lang=swift :
//     * public func useMySwiftSlice(slice: MySwiftLibrary.MySwiftSlice)
//     * }
//     */
//    public static MemorySegment useMySwiftSlice$address() {
//        return useMySwiftSlice_getLen.ADDR;
//    }
//
//    /**
//     * {@snippet lang=swift :
//     * public func useMySwiftSlice(slice: MySwiftLibrary.MySwiftSlice)
//     * }
//     */
//    public static long useMySwiftSlice_getLen(MemorySegment self) {
//        var mh$ = useMySwiftSlice_getLen.HANDLE;
//        try {
//            if (TRACE_DOWNCALLS) {
//                traceDowncall(self);
//            }
//            System.out.println("self = " + self);
//            return (long) mh$.invokeExact(self);
//        } catch (Throwable ex$) {
//            throw new AssertionError("should not reach here", ex$);
//        }
//    }
//
//    /**
//     * {@snippet lang=swift :
//     * public func useMySwiftSlice(slice: MySwiftLibrary.MySwiftSlice)
//     * }
//     */
//    public static long useMySwiftSlice_getLen(MySwiftSlice self) {
//        return useMySwiftSlice_getLen(self.$memorySegment());
//    }

}
