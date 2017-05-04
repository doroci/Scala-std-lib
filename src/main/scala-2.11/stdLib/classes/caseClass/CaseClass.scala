package stdLib.classes.caseClass

/**
  * Created by lee on 2017. 5. 4..
  */
object CaseClass extends App{

  val firstOrder = StartBucksMenu(americaNo = "ice AmericaNo", latte = "hot GreenTeaLatte", coldBrew = "hot coldBrew")
  val secondOrder = StartBucksMenu(americaNo = "hot AmericaNo", latte = "hot CafeLatte", coldBrew = "hot coldBrew")
  val thirdOrder = StartBucksMenu(americaNo = "", latte = "", coldBrew = "")


  def orders(order: StartBucksMenu) = order match {
    case StartBucksMenu("ice AmericaNo", "hot GreenTeaLatte", "hot coldBrew", "water") =>
        "order is success"
    case StartBucksMenu("ice AmericaNo", "hot GreenTeaLatte", "hot coldBrew", "") =>
        "order is failure"
    case StartBucksMenu("hot AmericaNo", "hot CafeLatte", "hot coldBrew", "water") =>
        "order is success"
    case StartBucksMenu("hot AmericaNo", "hot CafeLatte", "", "") =>
        "order is failure"
    case _ => "this is not order usage"
  }

  println(s" firstOrder, ${orders(firstOrder)}")
  println(s" secondOrder, ${orders(secondOrder)}")
  println(s" thirdOrder, ${orders(thirdOrder)}")


}

case class StartBucksMenu(americaNo: String, latte: String, coldBrew: String, water: String = "water") {}
