package emptyValue

/**
  * Created by lee on 2017. 1. 16..
  */
object EmptyValue extends App{

  /*

      [null] is Scala's null is the same as in Java.
          Any reference type can be null, like Strings, Objects, or your own classes.
          Also just like Java, value types like Ints can't be null.

      [Null] is a trait whose only instance is null.
          It is a subtype of all reference types, but not of value types.
          It purpose in existing is to make it so reference types can be assigned null and value types can't.

      [Nothing] is a trait that is guaranteed to have _zero_ instances
          It is a subtype of all other types. It has two main reasons for existing:
          to provide a return type for methods that **never** return normally (i.e. a method that always throws an exception).
          The other reason is to provide a type for Nil (explained below).

      [Unit] in Scala is the equivalent of void in Java.
           It's used in a function's signature when that function doesn't return a value.

      [Nil] is just an empty list, exactly like the result of List().
          It is of type List[Nothing].
          And since we know there are no instances of Nothing, we now have a list that is statically verifiable as empty.

   */


  val t0 = List() == Nil
  val t1 = None == None

  val t2 = None eq None // eq : AnyRef, This method is used to test whether the argument (arg0) is a reference to the receiver object (this)
  val t2_1 = Nil eq Nil
//  val t2_2 = 1 eq 1 => error!.  eq use type AnyRef
  val t2_2 = Seq(1) eq Seq(1)
  val t2_3 = "test" eq "test"
  val t2_4 = List(Nil) eq List(Nil)
  val t2_5 = List(1,2) eq List(1,2)
  val t2_6 = List("1","2") eq List("1","2")

  val t3 = None equals None  // equals : Any, This method is used to compare the receiver object (this) with the argument object (arg0) for equivalence.
  val t3_1 = Nil equals Nil
  val t3_2 = 1 equals 1
  val t3_3 = "test" equals "test"
  val t3_4 = List(Nil) equals List(Nil)
  val t3_5 = List(1,2) equals List(1,2)
  val t3_6 = List("1","2") equals List("1","2")

  val t4 = None == None  // == : Any,  None == None(That) is the same as if(None eq null) That eq null else None.equals(That)
  val t4_1 = Nil == Nil
  val t4_2 = 1 == 1
  val t4_3 = "test" == "test"
  val t4_4 = List(Nil) == List(Nil)
  val t4_5 = List(1,2) == List(1,2)
  val t4_6 = List("1","2") == List("1","2")


  val t5 = None.toString == None.toString
  val t6 = None.toList == Nil
  val t7 = None.isEmpty == None.isEmpty
  val t8 = None.asInstanceOf[Any] == None
  val t9 = None.asInstanceOf[AnyRef] == None
  val t10 = None.asInstanceOf[AnyVal] == None

  val optionalNone: Option[String] = None
  val t11 = optionalNone.isEmpty
  val t12 = optionalNone == None

  val optionalSome: Option[String] = Some("test")
  val t13 = optionalSome.isEmpty == None
  val t14 = optionalSome == None

  //default value
  val t15 = optionalNone.getOrElse("test")
  val t16 = optionalNone.getOrElse(",test")

  //Option value
  val t17 = optionalSome.getOrElse("test")
  val t18 = optionalSome.getOrElse(",test")


  println(s" List() == Nil, ${t0}")
  println(s" None == None, ${t1}")

  println(s" None eq None ${t2}")
  println(s" Nil eq Nil, ${t2_1}")
  println(s" 1 eq 1, ${t2_2}")
  println(s" 'test' eq 'test', ${t2_3}")
  println(s" List(Nil) eq List(Nil), ${t2_4}")
  println(s" List(1,2) eq List(1,2), ${t2_5}")
  println(s" List('1','2') eq List('1','2'), ${t2_6}")

  println(s" None equals None, ${t3}")
  println(s" Nil equals Nil, ${t3_1}")
  println(s" 1 equals 1, ${t3_2}")
  println(s" 'test' equals 'test', ${t3_3}")
  println(s" List(Nil) equals List(Nil), ${t3_4}")
  println(s" List(1,2) equals List(1,2), ${t3_5}")
  println(s" List('1','2') equals List('1','2'), ${t3_6}")

  println(s" None == None ${t4}")
  println(s" Nil == Nil, ${t4_1}")
  println(s" 1 == 1, ${t4_2}")
  println(s" 'test' == 'test', ${t4_3}")
  println(s" List(Nil) == List(Nil), ${t4_4}")
  println(s" List(1,2) == List(1,2), ${t4_5}")
  println(s" List('1','2') == List('1','2'), ${t4_6}")

  println(s" None.toString == None.toString, ${t5}")
  println(s" None.toList == Nil, ${t6}")
  println(s" None.isEmpty == None.isEmpty, ${t7}")
  println(s" None.asInstanceOf[Any] == None, ${t8}")
  println(s" None.asInstanceOf[AnyRef] == None, ${t9}")
  println(s" None.asInstanceOf[AnyVal] == None, ${t10}")
  println(s" optionalNone.isEmpty, ${t11}")
  println(s" optionalNone == None, ${t12}")
  println(s" optionalSome.isEmpty, ${t13}")
  println(s" optionalSome == None, ${t14}")
  println(s" optionalNone.getOrElse('test'), ${t15}")
  println(s" optionalNone.getOrElse(',test'), ${t16}")
  println(s" optionalSome.getOrElse('test'), ${t17}")
  println(s" optionalSome.getOrElse(',test'), ${t18}")




}