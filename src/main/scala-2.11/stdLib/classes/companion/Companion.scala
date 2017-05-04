package stdLib.classes.companion

/**
  * Created by lee on 2016. 10. 23..
  */
//SingleTon class
object Companion extends App{

  val id = "lee"
  val password = "1234"
  var conf = "conf"

  //Companion class
  //new 키워드 없이 인스턴스 생성 가능
  class Companion {

    def print(): Unit = {
      println(id)
      println(password)
      println(conf)
    }
  }


  //    import Companion.Companion
  //    def f = new Companion();
  //      f.pirnt()

  def newComp = new Companion.Companion() // required "new"
  newComp.print()

  println("-----------------------------")

  def comp = Companion  // not required "new"
  comp.conf = "is add value"
  newComp.print
  println("-----------------------------")

  def userInfo = new UserInfo();
  comp.conf = "is not add value"
  userInfo.print
  println("-----------------------------")



}
