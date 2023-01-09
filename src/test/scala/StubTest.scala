import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec

class StubTest extends AnyFlatSpec with MockFactory {
  "function MyObj.fn_cb" should "just callback by the given para once." in {
    val n = 123
    val expectRes = "test 123"

    val mf = stubFunction[Int, String]
    mf.when(n).returning(expectRes)

    val res = MyObj.fn_cb(n, mf)
    assert(res == expectRes)

    mf.verify(n).once
  }

  "function MyObj.fn_obj" should "just call mt.proc by the given para once." in {
    val n = 123
    val expectRes = "test 123"

    val mo = stub[MyObj.MyTool]
    (mo.proc _).when(n).returns(expectRes)

    val res = MyObj.fn_obj(n, mo)
    assert(res == expectRes)

    (mo.proc _).verify(n).once
  }
}
