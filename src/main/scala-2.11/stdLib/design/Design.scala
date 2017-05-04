package stdLib.design

/**
  * Created by lee on 2017. 4. 4..
  */

object Design extends App{


  trait A {
    def operation(): Unit
  }

  trait B extends A{
    abstract override def operation(): Unit = {
      super.operation()
      println("B")
    }
  }

  trait C extends A{
    abstract override def operation(): Unit = {
      super.operation()
      println("C")
    }
  }

  class Something() extends A{
    override def operation(): Unit = println("doSomething")
  }

  val something = new Something with B with C
  something.operation()

}

