package stdLib.enumerations

/**
  * Created by lee on 2017. 1. 18..
  */
object Enumerations extends App{


  object Alphabet extends Enumeration {
    val A = Value
    val B = Value
    val C = Value
    val D = Value
    val E = Value
    val F = Value
    val G = Value
    val H = Value
  }

  object Alphabet2 extends Enumeration {
    val A = Value(10,"Agent")
    val B = Value(11,"Big")
    val C = Value(12,"Cyber")
    val D = Value(13,"Domain")
    val E = Value(14,"Email")
    val F = Value(15,"Five")
    val G = Value(16,"Girl")
    val H = Value(17,"Hint")
  }

  object Alphabet3 extends Enumeration {
    val A = Value("Agent")
    val B = Value("Big")
    val C = Value("Cyber")
    val D = Value("Domain")
    val E = Value("Email")
    val F = Value("Five")
    val G = Value("Girl")
    val H = Value("Hint")
  }

  println("--------------------------------------------------------------------------------")
  println(s" Alphabet.A, ${Alphabet.A}")
  println(s" Alphabet.A.id, ${Alphabet.A.id}") // index value
  println(s" Alphabet.A.toString, ${Alphabet.A.toString}")
  println(s" Alphabet.A == Alphabet.A.toString, ${Alphabet.A == Alphabet.A.toString}") // Agent: Alphabet.Value, Agent: String
  println(s" Alphabet.A == Alphabet.A, ${Alphabet.A == Alphabet.A}")
  println(s" Alphabet.A == Alphabet.B, ${Alphabet.A == Alphabet.B}")
  println("--------------------------------------------------------------------------------")
  println(s" Alphabet2.A, ${Alphabet2.A}")
  println(s" Alphabet2.A.id, ${Alphabet2.A.id}") // index value
  println(s" Alphabet2.A.toString, ${Alphabet2.A.toString}")
  println(s" Alphabet2.A == Alphabet2.A.toString, ${Alphabet2.A == Alphabet2.A.toString}") // Agent: Alphabet.Value, Agent: String
  println(s" Alphabet2.A == Alphabet2.A, ${Alphabet2.A == Alphabet2.A}")
  println(s" Alphabet2.A == Alphabet2.B, ${Alphabet2.A == Alphabet2.B}")
  println("--------------------------------------------------------------------------------")
  println(s" Alphabet3.A, ${Alphabet3.A}")
  println(s" Alphabet3.A.id, ${Alphabet3.A.id}") // index value
  println(s" Alphabet3.A.toString, ${Alphabet3.A.toString}")
  println(s" Alphabet3.A == Alphabet3.A.toString, ${Alphabet3.A == Alphabet3.A.toString}") // Agent: Alphabet.Value, Agent: String
  println(s" Alphabet3.A == Alphabet3.A, ${Alphabet3.A == Alphabet3.A}")
  println(s" Alphabet3.A == Alphabet3.B, ${Alphabet3.A == Alphabet3.B}")



}
