import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec

// 實質共用
class SharingMocks1 extends AnyFlatSpec with MockFactory {
  val mf = stubFunction[Int, String]
  val n = 123
  val expectRes = "test 123"
  mf.when(n).returning(expectRes)

  "function MyObj.fn_cb" should "just callback by the given para once." in {
    MyObj.fn_cb(n, mf)
    val res = MyObj.fn_cb(n, mf)
    assert(res == expectRes)
  }

  it should "just use the same stub to test again." in {
    mf.when(n).returning(expectRes) // why????
    val res = MyObj.fn_cb(n, mf)
    assert(res == expectRes)
  }
}

// 只是共用程式碼，實際是不同的實體
class SharingMocks2 extends AnyFlatSpec with MockFactory {
    trait Test { // fixture context
        val mf = stubFunction[Int, String]
        val n = 123
        val expectRes = "test 123"
        mf.when(n).returning(expectRes)
    }

    "function MyObj.fn_cb" should "just callback by the given para once." in new Test {
        val res = MyObj.fn_cb(n, mf)
        assert(res == expectRes)
    }

    it should "just use the same stub to test again." in new Test  {
        val res = MyObj.fn_cb(n, mf)
        assert(res == expectRes)
    }
}
