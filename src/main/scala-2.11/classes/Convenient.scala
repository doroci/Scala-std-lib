package classes

/**
  * Created by lee on 2016. 10. 23..
  */
//SingleTon class
object Convenient {

  val id = "lee"
  val password = "1234"
  var conf = "conf"

  //Convenient class
  //인스턴스 생성 하지 않아도 접근 가능
  class Convenient {

    def print(): Unit ={
      println(id)
      println(password)
      println(conf)
    }
  }
}

class D {
  val id = "Kim"
  val password = "1234"
  def print(): Unit ={
    println(this.id)
    println(this.password)
  }
}

object M {

  def main(args : Array[String]): Unit ={
//    import Convenient.Convenient
//    def f = new Convenient();
//      f.pirnt()
    def f = new Convenient.Convenient()
      f.print()

    println("-----------------------------")

    def ff = Convenient
     ff.conf = "is add value"
     f.print()
    println("-----------------------------")

    def d = new D();
    ff.conf = "is not add value"
      d.print()
    println("-----------------------------")

  }
}
