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

    println(s"result, ${result }") // The "s" is String Interpolator

    class Car(val make: String, val model: String, val year: Short, val topSpeed: Short)

    object ChopShop {
      def unapply(x: Car) = Some(x.make, x.model, x.year, x.topSpeed)
    }

    val ChopShop(a, b, c, d) = new Car("Chevy", "Camaro", 1978, 120)

    println(s"a: ${a}, b: ${b}, c: ${c}, d: ${d}")

  }



}
