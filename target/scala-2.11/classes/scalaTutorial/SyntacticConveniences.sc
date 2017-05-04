
val xs = List(1,2,3)
val ys = List("1","2","3")

//equals
xs.map(x => x +1)
xs.map(_ +1 )
for(x <- xs) yield x+1

//equals
xs.filter(x => x % 2 == 0)  //1
xs.filter(_ % 2 == 0)  //2
for (x <- xs if x % 2 == 0) yield x //3

//equals
xs.filter(x => x % 2 == 0 ).map( x => x +1) //1
xs.filter(_ % 2 == 0).map(_ + 1)  //2
for (x <- xs if x % 2 == 0) yield x + 1 //3


//equals
xs.flatMap(x => ys.map(y => (x, y))) // 1

for(x <-xs; y <- ys) yield (x, y)  //2

for{  //3
  x <- xs
  y <- ys
} yield (x,y)


//equals
xs.filter{ x =>  //1
  x % 2 == 0
}.flatMap( x =>
  ys.map { y =>
    (x, y)
  }
)

for {  //2
  x <- xs if x % 2 == 0
  y <- ys
} yield (x, y)


// Named Parameters
case class Range(start: Int, end: Int, step: Int = 1)
val xz = Range(start = 1, end = 10)
xz.step
