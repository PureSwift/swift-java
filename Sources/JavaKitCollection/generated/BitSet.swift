// Auto-generated by Java-to-Swift wrapper generator.
import JavaKit
import JavaRuntime

@JavaClass("java.util.BitSet")
public struct BitSet {
  @JavaMethod
  public init(environment: JNIEnvironment? = nil)

  @JavaMethod
  public init(_ arg0: Int32, environment: JNIEnvironment? = nil)

  @JavaMethod
  public func cardinality() -> Int32

  @JavaMethod
  public func nextSetBit(_ arg0: Int32) -> Int32

  @JavaMethod
  public func toLongArray() -> [Int64]

  @JavaMethod
  public func previousSetBit(_ arg0: Int32) -> Int32

  @JavaMethod
  public func previousClearBit(_ arg0: Int32) -> Int32

  @JavaMethod
  public func intersects(_ arg0: BitSet?) -> Bool

  @JavaMethod
  public func size() -> Int32

  @JavaMethod
  public func get(_ arg0: Int32, _ arg1: Int32) -> BitSet?

  @JavaMethod
  public func get(_ arg0: Int32) -> Bool

  @JavaMethod
  public func equals(_ arg0: JavaObject?) -> Bool

  @JavaMethod
  public func length() -> Int32

  @JavaMethod
  public func toString() -> String

  @JavaMethod
  public func hashCode() -> Int32

  @JavaMethod
  public func clone() -> JavaObject?

  @JavaMethod
  public func clear(_ arg0: Int32)

  @JavaMethod
  public func clear(_ arg0: Int32, _ arg1: Int32)

  @JavaMethod
  public func clear()

  @JavaMethod
  public func isEmpty() -> Bool

  @JavaMethod
  public func set(_ arg0: Int32, _ arg1: Int32, _ arg2: Bool)

  @JavaMethod
  public func set(_ arg0: Int32, _ arg1: Int32)

  @JavaMethod
  public func set(_ arg0: Int32)

  @JavaMethod
  public func set(_ arg0: Int32, _ arg1: Bool)

  @JavaMethod
  public func flip(_ arg0: Int32, _ arg1: Int32)

  @JavaMethod
  public func flip(_ arg0: Int32)

  @JavaMethod
  public func nextClearBit(_ arg0: Int32) -> Int32

  @JavaMethod
  public func or(_ arg0: BitSet?)

  @JavaMethod
  public func toByteArray() -> [Int8]

  @JavaMethod
  public func and(_ arg0: BitSet?)

  @JavaMethod
  public func xor(_ arg0: BitSet?)

  @JavaMethod
  public func andNot(_ arg0: BitSet?)

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
extension JavaClass<BitSet> {
  @JavaStaticMethod
  public func valueOf(_ arg0: [Int64]) -> BitSet?

  @JavaStaticMethod
  public func valueOf(_ arg0: [Int8]) -> BitSet?
}