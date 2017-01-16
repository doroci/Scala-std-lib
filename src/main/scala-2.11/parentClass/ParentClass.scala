package parentClass

/**
  * Created by lee on 2017. 1. 16..
  */
object ParentClass extends App{

  class Animal(val firstName: String, val lastName: String) {}
  class Cat(override val firstName: String, override val lastName: String, val age: Long)
    extends Animal(firstName, lastName)
  val cat = new Cat("ruby", "coco", 10)


  //  ":" => Type ascription or context bounds
  val aniCat: Animal = cat

  println(s"animal firstName is '${cat.firstName}', lastName is '${cat.lastName}'")
  println(s"aniCat firstName is '${aniCat.firstName}', lastName is '${aniCat.lastName}'")

  abstract class AbsAnimal(val firstName : String, val lastName: String) {
    class Catch(val count: Long){}
  }
  class AbsCat(override val firstName: String, override val lastName: String, val age: Long)
    extends AbsAnimal(firstName, lastName)
  val absCat = new AbsCat("ruby", "coco", 10)


  val catchCount = new absCat.Catch(20) // absCat의 인스턴스를 통해 Catch Class를 생성한다.

  println(s"catCount is '${catchCount.count}'")




}
