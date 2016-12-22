package Implicit

import java.math.BigInteger;

/**
  * Created by lee on 2016. 11. 11..
  */
object Int2BigIntegerConvert {

  implicit def Int2BigIntegerConvert(value : Int) : BigInteger = new BigInteger(value.toString)
  def add(a : BigInteger, b: BigInteger) = a.add(b)


  def main(args : Array[String]): Unit ={

      System.out.println(add(Int2BigIntegerConvert(3),Int2BigIntegerConvert(6)) == Int2BigIntegerConvert(9))
      System.out.println(add(3,6) == 9)
      System.out.println(add(3,6))
      System.out.println(9)
      System.out.println(add(3,6) == Int2BigIntegerConvert(9))
      System.out.println(add(3,6) == (9 : BigInteger))
      System.out.println(add(3,6).intValue() == 9)


  }
}
