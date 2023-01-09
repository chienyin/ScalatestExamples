import org.scalatest.funsuite.AnyFunSuite

class MyObjTest_funsuite extends AnyFunSuite {
  test("MyObj.sq") {
    assert(MyObj.sq(3) === 9)
  }

  test("MyObj.cube") {
    assert(MyObj.cube(3) === 27)
  }
}
