

// # before sumInts
//def sumInts(a: Int, b: Int): Int =
//  if (a > b) 0 else a + sumInts(a + 1, b)

def cube(x: Int): Int = x * x * x

// # before sumCubes
//def sumCubes(a: Int, b: Int): Int =
//  if (a > b) 0 else cube(a) + sumCubes(a + 1, b)

// # before sumFactorials
//def sumFactorials(a: Int, b: Int): Int =
//  if (a > b) 0 else factorial(a) + sumFactorials(a + 1, b)

def factorial(n: Int): Int = {

  def iter(x: Int, result: Int): Int =
    if (x == 0) result
    else iter(x -1, result * x)

  iter(n, 1)

}



// Can we factor out the common pattern?
def sum(f: Int => Int, a: Int, b: Int): Int = {
  if (a > b) 0
  else { println("sum(a), " +(f(a)+sum(f, a + 1, b)));
    f(a) + sum(f, a + 1, b) }
}

def id(x: Int): Int = x
def sumInts(a: Int, b: Int) = sum(id, a, b)
def sumCubes(a: Int, b: Int) = sum(cube, a, b)
def sumFactorials(a: Int, b: Int) = sum(factorial, a, b )


sumFactorials(1,5)