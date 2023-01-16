import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.OneInstancePerTest

// OneInstancePerTest 保證每個測試程式會得到共用物件的 copy, 所以不會互相影響
class SharingMocks1 extends AnyFlatSpec with MockFactory with OneInstancePerTest {
  val mf = stubFunction[Int, String]
  val n = 123
  val expectRes = "test 123"
  mf.when(n).returning(expectRes)

  "function MyObj.fn_cb" should "just callback by the given para once." in {
    val res = MyObj.fn_cb(n, mf)
    assert(res == expectRes)
  }

  it should "just use the same stub to test again." in {
    val res = MyObj.fn_cb(n, mf)
    assert(res == expectRes)
  }
}

// 第二種寫法，共用物件放進trait，再把回傳值改成 new trait
// 這個寫法在 AsyncXXXSpec 會失敗，因為 AsyncXXXSpec 要求回傳型態必須是 Future[Assertion]，而這個寫法的回傳型態會變成 trait 物件
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
