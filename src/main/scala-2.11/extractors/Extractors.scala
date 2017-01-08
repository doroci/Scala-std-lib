package extractors


/**
  * Created by lee on 2016. 12. 28..
  */
object Extractors {

  def main(args: Array[String]) {

    case class Employee(firstName: String, lastName: String)

    val today = new java.util.Date
    val f_today = f"${today}%tY-${today}%tm-${today}%td " // The "f" is Interpolator

    val rob = Employee("Robin", "Williams")
    val result = rob match {
      case Employee("Robin", _) ⇒ s"BatMan, do you have time at ${f_today}?"
      case _ ⇒ "No I haven't"
    }

    println("-------------------------------------------------")
    println(s"result, ${result }") // The "s" is String Interpolator
    println("-------------------------------------------------")

    class Car(val make: String, val model: String, val year: Short, val topSpeed: Short)

    object ChopShop {
      def unapply(x: Car) = Some(x.make, x.model, x.year, x.topSpeed)
    }

    val ChopShop(a, b, c, d) = new Car("Chevy", "Camaro", 1978, 120)

    println("-------------------------------------------------")
    println(s"a: ${a}, b: ${b}, c: ${c}, d: ${d}")
    println("-------------------------------------------------")

    val x = new Car("Chevy", "Camaro", 1978, 120) match {
      case ChopShop(v1,v2,v3,v4) => (v1, v2)
      case _ => ("Ford","Edsel")
    }

    println("-------------------------------------------------")
    println(s"x._1: ${x._1}, x._2: ${x._2}")
    println("-------------------------------------------------")


    class TokenCar(val make: String, val model: String, val year: Short, val topSpeed: Short)
    class TokenEmployee(val firstName: String, val middleName: Option[String], val lastName: String)

    object Tokenizer {
      def unapply(x: TokenCar) = Some(x.make, x.model, x.year, x.topSpeed)

      def unapply(x: TokenEmployee) = Some(x.firstName, x.lastName)
    }

    val tokenResult = new TokenEmployee("Kurt", None, "Vonnegut") match {
      case Tokenizer(c, d) ⇒ "c: %s, d: %s".format(c, d)
      case _ ⇒ "Not found"
    }

    println("-------------------------------------------------")
    println(s"tokenResult, ${tokenResult}")
    println("-------------------------------------------------")



  }


}
