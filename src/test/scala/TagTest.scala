import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Tag

object MyTag1 extends Tag("com.vpon.tags.MyTag1")
object MyTag2 extends Tag("com.vpon.tags.MyTag2")

class TagTest_flatspec extends AnyFlatSpec {
  "function MyObj.sq" should "return the square of input x" taggedAs(MyTag1) in {
    println("tag1")
    assert(MyObj.sq(3) == 9)
  }
  it should "return the cube when calling MyObj.cube" taggedAs(MyTag1, MyTag2) in {
    println("tag2")
    assert(MyObj.cube(3) == 27)
  }
} 

