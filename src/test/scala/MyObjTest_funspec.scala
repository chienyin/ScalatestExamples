import org.scalatest.funspec.AnyFunSpec

class MyObjTest_funspec extends AnyFunSpec {
  describe("An area") {
    describe("when it is 2-D") {
        it("should be calculated by square") {
            assert(MyObj.sq(3) === 9)
        }

        it("should not be calculated by cube") {
            assert(MyObj.sq(3) !== 27)
        }
    }

    describe("when it is 3-D") {
        it("should be calculated by cube") {
            assert(MyObj.cube(3) === 27)
        }
    }
  }
}

