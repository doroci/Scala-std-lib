
/*
    call by name - Lazy evaluation
 */

def lessThan30(i: Int): Boolean = {
  println(s"\n$i less than 30?")
  i < 30
}

def moreThan20(i: Int): Boolean = {
  println(s"$i more than 20?")
  i > 20
}

val a = List(1, 25, 40, 5, 23)
val q0 = a.withFilter(lessThan30)
val q1 = q0.withFilter(moreThan20)
for (r <- q1) println(s"$r")



//def lessThan30(i: Int): Boolean = {
//  println(s"$i less than 30?")
//  i < 30
//}
//
//def moreThan20(i: Int): Boolean = {
//  println(s"$i more than 20?")
//  i > 20
//}
//
//val a = List(1, 25, 40, 5, 23)
//val q0 = a.filter(lessThan30);  println("")
//val q1 = q0.filter(moreThan20); println("")
//for (r <- q1) println(s"$r")




def doSomething(): Boolean = {
  println("something")
  doSomething()
}

//def callByValue(condition: Boolean, value: Boolean): Unit = {
//  println("2")
//  if (condition) value
//}

def callByName(condition: Boolean, f: => Boolean): Unit = {
  if (condition) f

  println("finish")
}


val condition = false
//callByValue(condition, doSomething())
callByName(condition, doSomething)