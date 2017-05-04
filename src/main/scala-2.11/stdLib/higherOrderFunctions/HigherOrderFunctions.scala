package stdLib.higherOrderFunctions

/**
  * Created by lee on 2016. 10. 29..
  */
object HigherOrderFunctions extends App{

  type fold = List[Any]

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

  val lambda2 : (Int,Int) => Int = (v1,v2) => v1+v2

  val foldList: (List[Int], List[String]) => fold = {

    (xs, xz) => xs ++ xz
  }


    println(lambda.apply("good"))
    println(lambda1.apply(12,15))
    println(lambda2(12,15))
    println(foldList(List(1,2,3),List("1","2","3")))


 }
