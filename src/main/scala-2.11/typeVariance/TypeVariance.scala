package typeVariance

/**
  * Created by lee on 2017. 1. 18..
  */
object TypeVariance extends App {

  val fruitBasket = new Container(new Banana)
  val explicitFruitBasket = new Container[Banana](new Banana)

  // [T]
  val inFruitBasket : Container[Banana] = new Container(new Banana)

  // [+T]
  val bananaBasket : Covariant[Fruits] = new Covariant[Banana](new Banana)
  val appleBasket : Covariant[Apple] = new Covariant[Apple](new Apple)


  // [-T]
  val fruitsBasket : Contravariant[Banana] = new Contravariant[Fruits](new Fruits)
  val citrusBasket: Contravariant[Citrus] = new Contravariant[Citrus](new Orange)
  val orangeBasket: Contravariant[Orange] = new Contravariant[Citrus](new Tangelo)
  val tangeloBasket: Contravariant[Tangelo] = new Contravariant[Citrus](new Orange)
  val bananaBasket2: Contravariant[Banana] = new Contravariant[Fruits](new Apple)


  println(s" fruitBasket.contents, ${fruitBasket.contents}")
  println(s" explicitFruitBasket.contents, ${explicitFruitBasket.contents}")
  println(s" inFruitBasket.contents, ${inFruitBasket.contents}")
  println(s" bananaBasket.contents, ${bananaBasket.contents}")
  println(s" appleBasket.contents, ${appleBasket.contents}")

  println(s" fruitsBasket.contents, ${fruitsBasket.contents}")
  println(s" citrusBasket.contents, ${citrusBasket.contents}")
  println(s" orangeBasket.contents, ${orangeBasket.contents}")
  println(s" tangeloBasket.contents, ${tangeloBasket.contents}")
  println(s" bananaBasket2.contents, ${bananaBasket2.contents}")



}



/*
    [+T]Covariant(공변성): - C[T'] is a subclass of C[T]
    [-T]Contravariant(반공변성): - C[T] is a subclass of C[T']
    [T]Invariant(무공변성): - C[T] and C[T'] are not related
 */

class Container[T](val a: T)(implicit manifest: scala.reflect.Manifest[T]) {
    def contents = manifest.runtimeClass.getSimpleName
}

class Covariant[+T](val a: T)(implicit manifest: scala.reflect.Manifest[T]) {
  def contents = manifest.runtimeClass.getSimpleName
}


class Contravariant[-T](a: T)(implicit manifest: scala.reflect.Manifest[T]) { //Can't receive a val because it would be in a covariant position
  def contents = manifest.runtimeClass.getSimpleName
}




class Orange extends Citrus
class Citrus extends Fruits
class Fruits

class Tangelo extends Citrus

class Apple extends Fruits
class Banana extends Fruits


