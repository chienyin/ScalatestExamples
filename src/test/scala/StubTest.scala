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
    (mo.proc _).when(n).returning(expectRes)

    val res = MyObj.fn_obj(n, mo)
    assert(res == expectRes)

    (mo.proc _).verify(n).once
  }

  "function MyObj.fn_obj2" should "just return the stubed value of MyObj.a" in {
    // 這裡 stub member 的方式是直接當成無參數函式設定
    // 官方文件的做法compile不過

    val n = 123
    val expectRes = 123

    val mo = stub[MyObj.MyTool]
    // (() => mo.a).when(n) // 官方文件裡的寫法，不能編譯
    (mo.a _).when().returning(n)

    val res = MyObj.fn_obj2(mo)
    assert(res == expectRes)
  }
}
