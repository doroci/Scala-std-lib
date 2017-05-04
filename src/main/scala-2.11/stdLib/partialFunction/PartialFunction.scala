package stdLib.partialFunction

/**
  * Created by lee on 2016. 11. 5..
  */
object PartialFunction {

  def pf1 : PartialFunction[Int,Int] = new PartialFunction[Int,Int]{

    override def isDefinedAt(x: Int): Boolean = x % 2  == 0

    override def apply(v1: Int): Int = v1 * v1
  }

  def pf2 : PartialFunction[Int,Int] = new PartialFunction[Int,Int]{

    override def isDefinedAt(x: Int): Boolean = x % 2  != 0

    override def apply(v1: Int): Int = v1 * v1 * v1
  }

  def casePf1 : PartialFunction[Int,Int] = {
    case x if ( x % 2 ) == 0 => x * 2
  }

  def casePf2 : PartialFunction[Int,Int] = {
    case x if ( x % 2 ) != 0 => x * 3
  }

  def caseTest(x : Int): Any = {
    val cp1 = casePf1
    val cp2 = casePf2
    val t1 = cp1 orElse cp2
    t1(x)
  }

  def casePf3 : PartialFunction[Int, String] ={
    case x if (x % 2) == 0 => "Even"
  }

  def casePf4 : PartialFunction[Int, String] ={
    case x if (x % 2) != 0 => "Odd"
  }


  def andThen(x : Int): Any = {

    val cp1 = casePf1
    val cp2 = casePf2
    val cp3 = casePf3
    val cp4 = casePf4

    val t1 = cp1 orElse cp2 andThen(cp3 orElse cp4)
    t1(x)

  }

  def main(args : Array[String]): Unit ={
    System.out.println(pf1(3))
    System.out.println(pf2(4))
    System.out.println("-------------------------------------")
    System.out.println(casePf1(2))
    System.out.println(casePf2(3))
    System.out.println("-------------------------------------")
    System.out.println(caseTest(3))
    System.out.println(caseTest(4))
    System.out.println(andThen(3))
    System.out.println(andThen(4))
  }

}
