object MyObj {
  val a = 10
  
  def sq(x:Int) = {
    x * x
  }
  
  def cube(x: Int) = {
    x * x * x
  }

  def fn_cb(n: Int, callback: (Int) => String) = {
    callback(n)
  }

  trait MyTool { def proc(s: Int): String }
  def fn_obj(n: Int, mt: MyTool) = {
    mt.proc(n)
  }
}
