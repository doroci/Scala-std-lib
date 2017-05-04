package stdLib.Implicit

import java.math.BigInteger;

/**
  * Created by lee on 2016. 11. 11..
  */
object Int2BigIntegerConvert extends App{

  implicit def Int2BigIntegerConvert(value : Int) : BigInteger = new BigInteger(value.toString)
  def add(a : BigInteger, b: BigInteger) = a.add(b)

    println(add(Int2BigIntegerConvert(3),Int2BigIntegerConvert(6)) == Int2BigIntegerConvert(9))
    println(add(3,6) == 9)
    println(add(3,6))
    println(9)
    println(add(3,6) == Int2BigIntegerConvert(9))
    println(add(3,6) == (9 : BigInteger))
    println(add(3,6).intValue() == 9)

}
