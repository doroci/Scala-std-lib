
def factorial(n: Int): Long = {

  def iter(x: Int, result: Int): Long =
      if (x == 0) result
      else iter(x -1, result * x)

    iter(n , 1)

}

factorial(30)