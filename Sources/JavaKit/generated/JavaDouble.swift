// Auto-generated by Java-to-Swift wrapper generator.
import JavaRuntime

@JavaClass("java.lang.Double", extends: JavaNumber.self)
public struct JavaDouble {
  @JavaMethod
  public init(_ arg0: Double, environment: JNIEnvironment? = nil)

  @JavaMethod
  public init(_ arg0: String, environment: JNIEnvironment? = nil) throws

  @JavaMethod
  public func equals(_ arg0: JavaObject?) -> Bool

  @JavaMethod
  public func toString() -> String

  @JavaMethod
  public func hashCode() -> Int32

  @JavaMethod
  public func isInfinite() -> Bool

  @JavaMethod
  public func compareTo(_ arg0: JavaDouble?) -> Int32

  @JavaMethod
  public func compareTo(_ arg0: JavaObject?) -> Int32

  @JavaMethod
  public func byteValue() -> Int8

  @JavaMethod
  public func shortValue() -> Int16

  @JavaMethod
  public func intValue() -> Int32

  @JavaMethod
  public func longValue() -> Int64

  @JavaMethod
  public func floatValue() -> Float

  @JavaMethod
  public func doubleValue() -> Double

  @JavaMethod
  public func isNaN() -> Bool

  @JavaMethod
  public func getClass() -> JavaClass<JavaObject>?

  @JavaMethod
  public func notify()

  @JavaMethod
  public func notifyAll()

  @JavaMethod
  public func wait(_ arg0: Int64) throws

  @JavaMethod
  public func wait(_ arg0: Int64, _ arg1: Int32) throws

  @JavaMethod
  public func wait() throws
}
extension JavaClass<JavaDouble> {
  @JavaStaticField
  public var POSITIVE_INFINITY: Double

  @JavaStaticField
  public var NEGATIVE_INFINITY: Double

  @JavaStaticField
  public var NaN: Double

  @JavaStaticField
  public var MAX_VALUE: Double

  @JavaStaticField
  public var MIN_NORMAL: Double

  @JavaStaticField
  public var MIN_VALUE: Double

  @JavaStaticField
  public var SIZE: Int32

  @JavaStaticField
  public var PRECISION: Int32

  @JavaStaticField
  public var MAX_EXPONENT: Int32

  @JavaStaticField
  public var MIN_EXPONENT: Int32

  @JavaStaticField
  public var BYTES: Int32

  @JavaStaticField
  public var TYPE: JavaClass<JavaDouble>?

  @JavaStaticMethod
  public func toString(_ arg0: Double) -> String

  @JavaStaticMethod
  public func hashCode(_ arg0: Double) -> Int32

  @JavaStaticMethod
  public func min(_ arg0: Double, _ arg1: Double) -> Double

  @JavaStaticMethod
  public func max(_ arg0: Double, _ arg1: Double) -> Double

  @JavaStaticMethod
  public func isInfinite(_ arg0: Double) -> Bool

  @JavaStaticMethod
  public func isFinite(_ arg0: Double) -> Bool

  @JavaStaticMethod
  public func doubleToRawLongBits(_ arg0: Double) -> Int64

  @JavaStaticMethod
  public func doubleToLongBits(_ arg0: Double) -> Int64

  @JavaStaticMethod
  public func longBitsToDouble(_ arg0: Int64) -> Double

  @JavaStaticMethod
  public func compare(_ arg0: Double, _ arg1: Double) -> Int32

  @JavaStaticMethod
  public func valueOf(_ arg0: String) throws -> JavaDouble?

  @JavaStaticMethod
  public func valueOf(_ arg0: Double) -> JavaDouble?

  @JavaStaticMethod
  public func toHexString(_ arg0: Double) -> String

  @JavaStaticMethod
  public func isNaN(_ arg0: Double) -> Bool

  @JavaStaticMethod
  public func sum(_ arg0: Double, _ arg1: Double) -> Double

  @JavaStaticMethod
  public func parseDouble(_ arg0: String) throws -> Double
}