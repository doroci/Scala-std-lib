package higherOrderFunctions

/**
  * Created by lee on 2016. 10. 29..
  */
object HigherOrderFunctions {

  val id = "good"

  //Function1, Function2, Function3 ....  뒤에 붙는 숫자 +1이 인자의 수를 의미하며, 스칼라의 내장 함수이다.
  //또한 apply 매서드를 overriding 한다.
  val lambda = new Function1[String,Boolean]{

    def apply(v1: String): Boolean = {
      v1.contains(id)
    }
  }

  val lambda1 = new Function2[Int,Int,Int] {

    def apply(v1:Int, v2:Int) : Int ={
      v1 +v2
    }

  }


  def main(args : Array[String]): Unit ={
    System.out.println(lambda.apply("good"))
    System.out.println(lambda1.apply(12,15))
  }

 }
