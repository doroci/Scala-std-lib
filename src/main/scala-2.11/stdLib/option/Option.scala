package stdLib.option

/**
  * Created by lee on 2016. 10. 22..
  */
object Option{

  def someValue(v: Option[String]): Option[String] = {
    if(v.isDefined) None else Some("someVal")
  }
  def returnValue(flag : Boolean): Option[String] ={
    if(flag) Some("Found value") else None
  }
  def matchValue(v: Option[Double]) : Option[Double] = {
    if(v.isDefined) None else Some(20.0)
  }

  def main(args: Array[String]){
    val sv = someValue(Some("someVal"))
    val ev = someValue(None)
    val rv1 = returnValue(true)
    val rv2 = returnValue(false)
    val mv1 = matchValue(Some(20.0))
    val mv2 = matchValue(None)


    println("boolean sv : "+sv.getOrElse())
    println("boolean ev : "+ev.getOrElse())
    println("rv1 getOrElse : "+rv1.getOrElse())
    println("rv2 getOrElse : "+rv2.getOrElse().equals(None))
    println("rv3 getOrElse : "+rv2.getOrElse("default function"))
    println("rv1.isEmpty : "+rv1.isEmpty)
    println("rv2.isEmpty : "+rv2.isEmpty)
    println("mv1 val :" +mv1.getOrElse())
    println("mv2 val :" +mv2.getOrElse())
  }
}
