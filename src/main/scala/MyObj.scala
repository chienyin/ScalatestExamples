object MyObj {
  def sq(x:Int) = {
    x * x
  }
  
  def cube(x: Int) = {
    x * x * x
  }

  def fn_cb(n: Int, callback: (Int) => String) = {
    callback(n)
  }

  trait MyTool { 
    def proc(s: Int): String 
    def a: Int
  }

  def fn_obj(n: Int, mt: MyTool) = {
    mt.proc(n)
  }

  def fn_obj2(mt: MyTool) = {
    mt.a
  }
}
