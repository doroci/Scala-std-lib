package infixType

/**
  * Created by lee on 2016. 11. 21..
  */
object InfixType {

  case class Person(name : String)
  case class Phone(name : String)
  case class Info(dollar : Int)
  case class Take[C,D](val c : C , val d : D)

  class Loves[A,B](val a : A , val b:  B)



  def announceCouple(couple :  Person Loves Person): Unit ={
    System.out.println(couple.a.name + " is in Love " +couple.b.name)
  }

  def getPhone(phone : Phone Take Phone , info : Info Take Phone)  : Unit ={
    System.out.println(phone.c.name +" has a " +phone.d.name )
    System.out.println(phone.c.name +" is " +info.c.dollar +" in " +info.d.name)
  }

  val romeo = new Person("Roemo")
  val juliet = new Person("Juliet")

  val iphone = new Phone("Iphone")
  val color = new Phone("color")
  val info = new Info(5000)
  val aShop = new Phone("A-Shop")

  def main(args: Array[String]) {

    announceCouple(new Loves(romeo,juliet))
    getPhone(new Take(iphone,color), new Take(info,aShop))
  }





}
