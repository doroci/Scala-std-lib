package nameAndDefaultArguments

/**
  * Created by lee on 2016. 12. 28..
  */
object NameAndDefaultArguments{

  class WithoutClassParameters {

    def addColors(red: Int, green: Int, blue: Int) = {
      (red, green, blue)
    }

    def addColorWithDefaults(red: Int = 10, green: Int = 20, blue: Int = 0) = {
      (red, green, blue)
    }
  }


  case class WithClassParameters(val defaultRed: Int, val defaultGreen: Int, val defaultBlue: Int) {
    def addColors(red: Int, green: Int, blue: Int) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }
  }


  case class WithClassParametersInClassDefinition(val defaultRed: Int = 0, val defaultGreen: Int = 255, val defaultBlue: Int = 100) {
    def addColors(red: Int, green: Int, blue: Int) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }
  }


  def main(args: Array[String]) {

    println("-------------------------------------------------------------------------------")
    val meTest1 = new WithoutClassParameters
    val myColorTest1 = meTest1.addColors(green = 0, red = 255, blue = 0)
    println(s"myColorTest1, $myColorTest1")

    println("-------------------------------------------------------------------------------")
    val meTest2 = new WithoutClassParameters
    val myColorTest2 = meTest2.addColorWithDefaults(green = 255)
    println(s"mycolorTest2, $myColorTest2")

    println("-------------------------------------------------------------------------------")
    val meTest3 = WithClassParameters(40, 50, 60)
    val myColorTest3 = meTest3.addColors(green = 50, red = 60, blue = 40)
    println(s"mycolorTest3, $myColorTest3")

    println("-------------------------------------------------------------------------------")
    val meTest4 = WithClassParameters(10, 20, 30)
    val myColorTest4 = meTest4.addColorsWithDefaults(green = 70)
    println(s"mycolorTest4, $myColorTest4")

    println("-------------------------------------------------------------------------------")
    val meTest5 = WithClassParametersInClassDefinition()
    val myColorTest5 = meTest5.addColorsWithDefaults(green = 70)
    println(s"mycolorTest5, $myColorTest5")

    println("-------------------------------------------------------------------------------")
    def reduce(a: Int, f: (Int, Int) ⇒ Int = _ + _): Int = f(a, a)
    val reduceTest1 = reduce(10)
    val reduceTest2 = reduce(10 + 10)
    val reduceTest3 = reduce(10 - 10)
    val reduceTest4 = reduce(10 * 10)

    println(s"reduceTest1, $reduceTest1")
    println(s"reduceTest2, $reduceTest2 ")
    println(s"reduceTest3, $reduceTest3")
    println(s"reduceTest4, $reduceTest4")
    println("-------------------------------------------------------------------------------")

  }

}
