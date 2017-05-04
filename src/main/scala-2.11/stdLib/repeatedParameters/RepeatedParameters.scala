package stdLib.repeatedParameters

/**
  * Created by lee on 2017. 1. 16..
  */

object RepeatedParameters extends App{


  def repeatedParameterMethod(x: Int, y: String, z: Any*) = {
    "%d %ss can give you %s".format(x, y, z.mkString(", "))
  }


  println(repeatedParameterMethod(3, "egg", "a delicious sandwich", "protein", "high cholesterol"))
  println(repeatedParameterMethod(3, "egg", List("a delicious sandwich", "protein", "high cholesterol")))

  // "_*" => vararg expansion, Reference : http://docs.scala-lang.org/tutorials/FAQ/finding-symbols.html
  println(repeatedParameterMethod(3, "egg", List("a delicious sandwich", "protein", "high cholesterol"): _*))



}
