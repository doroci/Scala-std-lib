package PartiallyAppliedFunctions

/**
  * Created by lee on 2016. 11. 4..
  */
object partiallyAppliedFunctions {

  def sum(a: Int, b: Int, c: Int) = a+b+c
  def multiply(x: Int, y: Int) = x*y

  def main(args : Array[String]): Unit ={
    val sumTest = sum _
      System.out.println(sumTest(1,3,5))
      System.out.println(sum(5,7,9))
      System.out.println("------------------------------")

    val appliedSum = sum(1,5, _:Int)
      System.out.println(appliedSum(4))
      System.out.println("------------------------------")

    val multiplyInstanceOf = (multiply _).isInstanceOf[Function2[_,_,_]]
      System.out.println(multiplyInstanceOf)
      System.out.println("------------------------------")


    val multiplyCurried = (multiply _).curried // Int => (Int => Int) = <function1>
      System.out.println(multiplyCurried(10)(20))
      System.out.println("------------------------------")


    val multiplyCurreidAdd = multiplyCurried(4)  // Int => Int = <function1>
      System.out.println(multiplyCurreidAdd(5))
      System.out.println("------------------------------")
  }
}
