
sealed trait Symbol

case class Note(name: String, duration: String, octave: Int) extends Symbol
case class Rest(duration: String) extends Symbol

val s1: Symbol = Note("C","Quater",3)

val symbol1: Symbol = Note("C","Quater",3)
val symbol2: Symbol = Rest("whole")


def symbolDuratin(symbol: Symbol): String =
  symbol match {
    case Note(name, duration, octave) => duration
    case Rest(duration) => duration
  }


def nonExhaustiveDuration(symbol: Symbol): String =
  symbol match {
    case Rest(duration) => duration
  }


symbolDuratin(symbol2)

//nonExhaustiveDuration(symbol1)


// algebraic data type
  // Ref: http://tpolecat.github.io/presentations/algebraic_types.html#14
  // Option: algebra computations that may fail to return a value
  sealed trait Option[+T]
  case object None extends Option[Nothing]
  case class Some[T](a: T) extends Option[T]

  def safeDiv(a: Int, b: Int): Option[Int] =
    if ( b != 0) Some(a / b) else None

  safeDiv(10, 2)
  safeDiv(10, 0)

  // Either: computations that may return this or that
  sealed trait Either[+A, +B]
  case class Left[A](a: A) extends Either[A, Nothing]
  case class Right[B](b: B) extends Either[Nothing, B]

  def safeDiv2(a: Int, b: Int): Either[String, Int] =
    if (b != 0) Right(a / b) else Left("Divide by zero")

  safeDiv2(10,2)
  safeDiv2(10,0)


  // Try: computations that may fail with an exception
  sealed trait Try[+A]
  case class Success[A](a: A) extends Try[A]
  case class Failure[A](t: Throwable) extends Try[A]
//  def safeDiv3(a: Int, b: Int): Try[Int] =
//    Try(a / b)

  // List: computations that may return many answers

  sealed trait List[+A]
  case object Nil extends List[Nothing] //case class는 인자가 없으면 사용 못한다.
  case class ::[A](head: A, tail: List[A]) extends List[A]

/*
   object List {
     def apply[A](as: A*): List[A] =

  def sum(ns: List[Int]): Int =
    ns match {
      case Nil => 0
      case n :: ns => n + sum(ns)
    }

  sum(List(1,2,3))
*/


