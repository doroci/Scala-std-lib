package emptyValue

/**
  * Created by lee on 2017. 1. 16..
  */
object EmptyValue extends App{

  /*

      [null] is Scala's null is the same as in Java.
          Any reference type can be null, like Strings, Objects, or your own classes.
          Also just like Java, value types like Ints can't be null.

      [Null] Null is a trait whose only instance is null.
          It is a subtype of all reference types, but not of value types.
          It purpose in existing is to make it so reference types can be assigned null and value types can't.

      [Nothing] Nothing is a trait that is guaranteed to have _zero_ instances
          It is a subtype of all other types. It has two main reasons for existing:
          to provide a return type for methods that **never** return normally (i.e. a method that always throws an exception).
          The other reason is to provide a type for Nil (explained below).

      [Unit] Unit in Scala is the equivalent of void in Java.
           It's used in a function's signature when that function doesn't return a value.

      [Nil] Nil is just an empty list, exactly like the result of List().
          It is of type List[Nothing].
          And since we know there are no instances of Nothing, we now have a list that is statically verifiable as empty.

   */


  val t1 = List() == Nil
  val t2 = None == None
  val t3 = None eq None
  val t4 = None.toString == None.toString
  val t5 = None.toList == Nil
  val t6 = None.isEmpty == None.isEmpty
  val t7 = None.asInstanceOf[Any] == None
  val t8 = None.asInstanceOf[AnyRef] == None
  val t9 = None.asInstanceOf[AnyVal] == None

  val optionalNone: Option[String] = None
  val t10 = optionalNone.isEmpty
  val t11 = optionalNone == None

  val optionalSome: Option[String] = Some("test")
  val t12 = optionalSome.isEmpty == None
  val t13 = optionalSome == None

  //default value
  val t14 = optionalNone.getOrElse("test")
  val t15 = optionalNone.getOrElse(",test")

  //Option value
  val t16 = optionalSome.getOrElse("test")
  val t17 = optionalSome.getOrElse(",test")


  println(s"List() == Nil, ${t1}")
  println(s"None == None, ${t2}")
  println(s"None eq Nonem ${t3}")
  println(s"None.toString == None.toString, ${t4}")
  println(s"None.toList == Nil, ${t5}")
  println(s"None.isEmpty == None.isEmpty, ${t6}")
  println(s"None.asInstanceOf[Any] == None, ${t7}")
  println(s"None.asInstanceOf[AnyRef] == None, ${t8}")
  println(s"None.asInstanceOf[AnyVal] == None, ${t9}")
  println(s"optionalNone.isEmpty, ${t10}")
  println(s"optionalNone == None, ${t11}")
  println(s"optionalSome.isEmpty, ${t12}")
  println(s"optionalSome == None, ${t13}")

  println(s"optionalNone.getOrElse('test'), ${t14}")
  println(s"optionalNone.getOrElse(',test'), ${t15}")
  println(s"optionalSome.getOrElse('test'), ${t16}")
  println(s"optionalSome.getOrElse(',test'), ${t17}")




}