import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec

class MockTest extends AnyFlatSpec with MockFactory {
  "function MyObj.fn_obj" should "just call mt.proc by the given para once." in {
    val n = 123
    val expectRes = "test 123"

    val mo = mock[MyObj.MyTool]
    (mo.proc _).expects(n).returning(expectRes).once

    val res = MyObj.fn_obj(n, mo)
    assert(res == expectRes)
  }

  it should "do twice if we test twice." in {
    // expects可以分階段使用，先設定一次expects然後使用，用完後再設定expects再使用
    val n = 123
    val expectRes = "test 123"
    val mo = mock[MyObj.MyTool]

    (mo.proc _).expects(n).returning(expectRes).once
    MyObj.fn_obj(n, mo)

    (mo.proc _).expects(n).returning(expectRes).once
    val res = MyObj.fn_obj(n, mo)

    assert(res == expectRes)
  }

  it should "check complicated expection by where." in {
    // 更複雜奇怪的 expact 可以使用 where, 比如我期望輸入參數是個奇數：
    val n = 123
    val expectRes = "test 123"
    val mo = mock[MyObj.MyTool]

    (mo.proc _)
    .expects( where {n: Int => n % 2 == 1} )
    .returning(expectRes).once
    
    MyObj.fn_obj(n, mo)

    (mo.proc _).expects(n).returning(expectRes).once
    val res = MyObj.fn_obj(n, mo)

    assert(res == expectRes)
  }
}
