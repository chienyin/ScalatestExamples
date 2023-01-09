import org.scalatest.flatspec.AnyFlatSpec

class MyObjTest_flatspec extends AnyFlatSpec {
  "function MyObj.sq" should "return the square of input x" in {
    assert(MyObj.sq(3) == 9)
  }
  it should "return the cube when calling Calculator.cube" in {
    assert(MyObj.cube(3) == 27)
  }
} 
