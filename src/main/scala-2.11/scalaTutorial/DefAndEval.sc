def square(x: Double) = x * x

def sumOfSquares(x: Double, y: Double) = square(x) + square(y)

def power(x: Double, y: Int): Double = ???


def loop: Int = loop

def x = loop

// infinite loop
//val e = loop



def factorial(n: Int): Int =
  if ( n == 1) 1
  else { println(factorial(n-1).toString); factorial(n -1)* (n)}

factorial(4)


