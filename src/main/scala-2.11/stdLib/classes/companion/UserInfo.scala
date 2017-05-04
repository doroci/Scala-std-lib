package stdLib.classes.companion

/**
  * Created by lee on 2016. 11. 5..
  */
class UserInfo {
  val id = "Kim"
  val password = "1234"

  def print: Unit = {
    println(this.id)
    println(this.password)
  }
}
