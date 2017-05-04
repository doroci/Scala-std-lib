

object Rational{

}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y


}



case class CaseRational(x: Int, y: Int){}

val r = new Rational(1,2)
r.denom

val cr = CaseRational(1,2)

Ra