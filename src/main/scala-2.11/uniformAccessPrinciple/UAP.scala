package uniformAccessPrinciple

/**
  * Created by lee on 2017. 1. 17..
  */
object UAP extends App{

  class Test1(val age: Int = 10)
  class Test2(_age: Int) {  // _age can be changed to a val or vice versa
    def age: Int = _age
  }

  val test1 = new Test1(10).age
  val test3 = new Test2(20).age

  println(test1)
  println(test3)
}
