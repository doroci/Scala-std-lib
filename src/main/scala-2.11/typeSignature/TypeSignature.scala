package typeSignature

/**
  * Created by lee on 2017. 1. 17..
  */
object TypeSignature extends  App{

  val ts : List[String] = "What" :: "is" :: "it" :: "Type?" :: Nil
  val inferTs = "What" :: "is" :: "it" :: "Type?" :: Nil

  trait Randomizer[A]{
    def make() : A
  }

  class IntRandomizer extends Randomizer[Int] {
    override def make(): Int = {
      import util.Random
      Random.nextInt()
    }
  }

  val intRead = new IntRandomizer
  val result = (intRead.make < Int.MaxValue)

  println("--------------------------------------------------------------------------------------")
  println(ts)
  println(inferTs)
  println("--------------------------------------------------------------------------------------")
  println(s" result, ${result}")
  println(s" intRead.make.isInstanceOf[Int], ${intRead.make.isInstanceOf[Int]}")
  println("--------------------------------------------------------------------------------------")

  val classMetaInfoCN1 = classOf[String].getCanonicalName
  val classMetaInfoCN2 = classOf[List[String]].getCanonicalName
  val classMetaInfoCN3 = classOf[List[List[Int]]].getCanonicalName  // not infer type
  val classMetaInfoSN1 = classOf[String].getSimpleName
  val classMetaInfoSN2 = classOf[List[String]].getSimpleName
  val classMetaInfoSN3 = classOf[List[List[Int]]].getSimpleName //not infer type


  println(classMetaInfoCN1)
  println(classMetaInfoCN2)
  println(classMetaInfoCN3)
  println(classMetaInfoSN1)
  println(classMetaInfoSN2)
  println(classMetaInfoSN3)

  println("--------------------------------------------------------------------------------------")
}
