package classes
/**
  * Created by lee on 2016. 11. 2..
  */
object CaseClass {

  def main(args : Array[String]): Unit ={
    eqaulsTest()
  }

  def eqaulsTest(): Unit ={

   val t1 = TestClass("lee",20)
   val t2 = TestClass("lee",20)
   val t3 = TestClass("lee",30)
   val t4 = TestClass("kim",30)

    System.out.println(t1 eq t2)  // identity object
    System.out.println(t1 equals t2)  // equals object
    System.out.println(t3.eq(t4))
    System.out.println(t3.equals(t4))

  }


}

case class TestClass(name : String, age : Integer)






