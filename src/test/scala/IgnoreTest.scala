import org.scalatest.flatspec.AnyFlatSpec

class IgnoreTest_flatspec1 extends AnyFlatSpec {
  "function MyObj.sq" must "return the square of input x" ignore {
    assert(MyObj.sq(3) == 900000)
  }
  ignore can "return the cube when calling MyObj.cube" in {
    assert(MyObj.cube(3) == 900000)
  }
}

import org.scalatest.Ignore
@Ignore
class IgnoreTest_flatspec2 extends AnyFlatSpec {
  "function MyObj.sq" must "return the square of input x" in {
    assert(MyObj.sq(3) == 900000)
  }
  it can "return the cube when calling MyObj.cube" in {
    assert(MyObj.cube(3) == 900000)
  }
}

