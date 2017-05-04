
// 패턴매칭
val t = 10

t match {
  case i: Int => i + 1
  case i if i == 0 => i + 100
  case _ => println("none")
}


def bigger(o: Any): Any = {
  o match {
    case i if i == 0 => println("i == 0")
    case i: Int => println("Integer")
    case d: Double if d < 0.0 => println("d < 0.0")
    case d: Double => println("Double")
    case _ => println("None")
  }
}

bigger(1) //expected to "Integer"
bigger(0) //expected to "i == 0"
bigger(-1.0) //expected to "d < 0.0"
bigger(1.0) //expected to "Double"
bigger("g") // expected to "None"


case class Calculator(brand: String, model: String)

val c1 = Calculator("casio","M921")
val c2 = Calculator("Rolex", "a129")

def calType(calc: Calculator) = calc match {
  case Calculator("casio","M921") => "casio good"
  case Calculator("casio","M900") => "casio bad"
  case Calculator("Rolex","a129") => "Rolex good"
  case Calculator("Rolex", "123") => "Rolex bad"
  case _ => "None"
}

calType(c1) // expected to "casio good"
calType(c2) // expected to "Rolex good"




