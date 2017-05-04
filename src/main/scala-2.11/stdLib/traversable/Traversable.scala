package stdLib.traversable

import scala.collection.immutable.Stream.cons

/**
  * Created by lee on 2016. 12. 20..
  */
object Traversable {


  def traversable1: Unit ={
    val set = Set(1, 3, 5, 9)
    val list = List(3, 4, 5, 10)
    val map = set.map(_ * 4)
    val result = set ++ list
    val result2 = list ++ set

    println(s"map, $map")
    println(s"set ++ list, $result")
    println(s"list ++ set, $result2")
  }

  def traversable2 : Unit ={
    val nestedList = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
    val flatten = nestedList.flatten
    val flatMap = nestedList.flatMap( _.map( _ * 2))
    println(s"flatten, $flatten")
    println(s"flatMap, $flatMap")
  }

  def traversable3 : Unit ={
    val list = List(4, 6, 7, 8, 9, 13, 14)
    val collect = list.collect {
      case x: Int if (x % 2 == 0) ⇒ x * 3
    }
    println(s"collect, $collect")

  }

  def traversable4: Unit = {
    val list = List(4, 6, 7, 8, 9, 13, 14)
    val partialFunction1: PartialFunction[Int, Int] = {
      case x: Int if x % 2 == 0 ⇒ x * 3
    }
    val partialFunction2: PartialFunction[Int, Int] = {
      case y: Int if y % 2 != 0 ⇒ y * 4
    }

    val partialFunction = list.collect(partialFunction1 orElse partialFunction2)

    println(s"std_Lib.partialFunction , $partialFunction")
  }

  def collectionToCollection: Unit ={

    val set = Set(1, 5, 7, 8, 9, 20 ,10)
    val setToListIsTrue = set.toList.isInstanceOf[List[_]]
    println(s"setToListIsTrue ?, $setToListIsTrue")

    val list = List(5,6,7,8,9)
    val listToList = list.toList
    val isTrue = listToList eq list
    println(s"listToList is True ? $isTrue" )

    // toSeq : Iterable을 반환
    val set2 = Set( 4, 6, 7, 8, 9, 13, 14)
    val setToSeqIsTrue = set.toSeq.isInstanceOf[Seq[_]]
    println(s"setToSeqIsTrue ? $setToSeqIsTrue")

    // toIndexedSeq : Vector나 String을 반환한다.
    val set3 = Set(4, 6, 7, 8, 9, 13, 14)
    val setToIndexedSeqIsTrue = set3.toIndexedSeq.isInstanceOf[IndexedSeq[_]]
    println(s"setToIndexedSeqIsTrue ? $setToIndexedSeqIsTrue")

    // toStream : lazy한 리스트를 반환
    val list2 = List(4, 6, 7, 8, 9, 13, 14)
    val listToStream = list2.toStream
    val listToStreamIsTrue = listToStream.isInstanceOf[Stream[_]]
    val listToStreamTake3 = listToStream take 3

    println(s"listToStreamIsTrue, $listToStreamIsTrue")
    println(s"listToStreamTake3 , $listToStreamTake3")

  }

  def traversable5: Unit = {
    val list3 = List(12, 34, 12, 11 , 15)
    val list4 = List()
    /*
      head : 컬렉션의 첫번째 원자를 반환한다.
      headOption : 켈렉션의 첫번째 원자가 존재하면 Some, 없으면 None
    */
    val listHead = list3.head
    val listHeadOption = list3.headOption
    val listHeadOptionNone = list4.headOption

    println(s"listHead, $listHead")
    println(s"listHeadOption, $listHeadOption")
    println(s"listHeadOptionNone, $listHeadOptionNone")

    /*
        last : 컬렉션의 마지막째 원자를 반환한다.
        lastOption : 켈렉션의 마지막째 원자가 존재하면 Some, 없으면 None
     */
    val listLast = list3.last
    val listLastOption = list3.lastOption
    val listLastOptionNone = list4.lastOption

    println(s"listLast, $listLast")
    println(s"listLastOption, $listLastOption")
    println(s"listLastOptionNone, $listLastOptionNone")

    // find : 조건에 해당하는 첫번째 아이탬을 리턴한다.
    val list5 = List(10, 20, 30, 10, 5)
    val list6 = List(10, 20, 30)
    val listFind = list5.find( _ % 2 != 0)
    val listFindNone = list6.find( _ % 2 != 0)
    println(s"listFind, $listFind")
    println(s"listFindNone, $listFindNone")

    /*
      init : 마지막째 원자를 제거하고 반환
      tail : 첫번째 원자를 제거하고 반환
    */
    val list7 = List(1, 3, 5, 6)
    val listInit = list7.init
    val listTail = list7.tail
    println(s"listTail, $listTail")
    println(s"listInit, $listInit")

    // slice : slice(A,B) 범위에서 A<= x <B의 범위값을 리턴한다.
    val list8 = List(10, 3, 7, 55, 1)
    val listSlice = list8.slice(2,4)
    println(s"listSlice, $listSlice")


  }


  def traversable6: Unit ={

    //take : 주어진 파라미터의 해당하는 만큼의 원자의 값을 가져온다.
    val list9 = List(10, 19, 3, 6, 9)
    val listTake = list9.take(3)
    println(s"listTake, $listTake")

    //drop : 주어진 파라미터의 해당하는 제외한 원자값의 나머지를 가져온다
    def streamer(v : Int) : Stream[Int] = cons(v, streamer(v+1))
    val st = streamer(2)
    val stTake3 = st take 3 toList
    val stDropAndTake = ( (st drop 5) take 3).toList
    println(s"stTake3, $stTake3") // Stream(2,?) take 3 => List(2,3,4)
    println(s"stDropAndTake, $stDropAndTake") // Stream(5,?) take 3=> List(7,8,9)


    // splitAt : 입력한 숫자의 position을 기준으로 스플릿하여 튜플 형태로 반환한다.
    // (take) n, (drop) n
    val array = Array(87, 44, 5, 4, 200, 10, 39, 100)
    val splitResult = array splitAt 3
    val splitResult_1 = splitResult._1
    val splitResult_2 = splitResult._2

    println(s"splitResult, $splitResult")
    println(s"splitResult_1, $splitResult_1")
    println(s"splitResult_2, $splitResult_2")

    // span : 해당 statement에 true인 엘리먼트에 도달하였을때, 스플릿하여 튜플 형태로 반환한다.
    // ( takeWhile p, dropWhile p )
    val array2 = Array(10,20,5,100,300,10,2)
    val spanResult = array2 span (_ < 50)
    val spanResult_1 = spanResult._1
    val spanResult_2 = spanResult._2

    println(s"spanResult, $spanResult")
    println(s"spanResult_1, $spanResult_1")
    println(s"spanResult_2, $spanResult_2")

    // partition : 해당 statement에 ture면 첫번째 듀플의 엘리먼트, false면 듀플의 두번째 엘리먼트에에 값을 filter하여 분별한다.
    //  (xs filter p , xs filterNot p)
    val array3 = Array(87, 44, 5, 4, 200, 10, 39, 100)
    val partitionResult = array partition (_ < 100)
    val partitionResult_1 = partitionResult._1
    val partitionResult_2 = partitionResult._2

    println(s"partitionResult, $partitionResult")
    println(s"partitionResult_1, $partitionResult_1")
    println(s"partitionResult_2, $partitionResult_2")

    //groupBy : Map타입으로 카테고리화 하여 반환한다.
    val oddAndSmallPartial : PartialFunction[Int, String] = {
      case x : Int if ( (x % 2 !=0 ) && (x < 100) ) => "Odd and lee than 100"
    }

    val evenAndSmallPartial : PartialFunction[Int, String] ={
      case x : Int if ( ( x != 0) && (x % 2 == 0 ) && x < 100 ) => "Even and less than 100"
    }

    val negativePartial: PartialFunction[Int, String] ={
      case x : Int if (x < 0 ) => "Negative Number"
    }

    val largePartial: PartialFunction[Int, String] ={
      case x : Int if (x > 99) => "Large Number"
    }

    val zeroPartial : PartialFunction[Int, String] ={
      case x : Int if (x == 0) => "Zero"
    }

    val groupByResult = array3 groupBy {
      oddAndSmallPartial orElse
        evenAndSmallPartial orElse
        largePartial orElse
        zeroPartial
    }

    val evenAndLessThan100 = groupByResult("Even and less than 100") size
    val largeNumber = groupByResult("Large Number") size

    println(s"array3 groupBy{}, $groupByResult")
    println(s"evenAndLessThan100, $evenAndLessThan100")
    println(s"largeNumber, $largeNumber")


    // forall : statement에 해당하는 모든 원자값이 해당하면 true, 아니면 false
    val list = List(100,200,300,530,130,200,140)
    val forallResult = list forall ( _ > 100)
    println(s"forallResult, $forallResult")

    // exists : statement에 해당하는 모든 원자값이 해당하면 true, 아니면 false
    val existsResult = list exists ( _ > 100)
    println(s"existsResult, $existsResult")

    // /: or fodLeft : 피보나치 수열이랑 같다고 보면되는데,
    // 두 엘리먼트의 합을 첫번째 엘리먼트의 값으로 재할당 하고 다시 이후 엘리먼트와 연산을한다.
    val list2 = List(10,20,30,40,50)
    val resultFoldLeft1 = ( 0 /: list2){
      (`running total`,`next element`) => `running total` - `next element`
    }

    val resultFoldLeft2 = list2.foldLeft(0) {
      (`running total`,`next element`) => `running total` - `next element`
    }

    val resultFoldLeft3 = (0 /: list2 )(_ - _)
    val resultFoldLeft4 = list2.foldLeft(0)(_ - _)

    // 예상값 : (((((0 - 50) - 40) - 30) - 20) - 10)
    println(s" (0 /: list){}, $resultFoldLeft1")
    println(s" list.foldLeft(0){}, $resultFoldLeft2")
    println(s" (0 / : list)(_ - _), $resultFoldLeft3")
    println(s" list.foldLeft(0)(- _ -), $resultFoldLeft1")

    // foldRight : foldLeft와 원리는 같으나,  엘리먼트의 재할당 위치가 두번째 엘리먼트에서 첫번째 엘리먼트에서 연산된다.
    val resultFoldRight1 = ( list2 :\ 0){
      (`running total`,`next element`) => `running total` - `next element`
    }

    val resultFoldRight2 = list2.foldRight(0) {
      (`running total`,`next element`) => `running total` - `next element`
    }

    val resultFoldRight3 = (list2 :\ 0 )(_ - _)
    val resultFoldRight4 = list2.foldRight(0)(_ - _)

    // 예상값 : (50 - (40 - (30 - (20 - (10 - 0))))
    println(s" ( list : \0){}, $resultFoldRight1")
    println(s" list.foldRight(0){}, $resultFoldRight2")
    println(s" ( list : \0)(_ - _), $resultFoldRight3")
    println(s" list.foldRight(0)(- _ -), $resultFoldRight4")


    // reduceLeft : foldLeft와 유사
    val reduceLeft = list2.reduceLeft{ _ + _ }
    val stringList = List("a","b","c","d","e","f")
    val stringLeftResult = stringList.reduceLeft(_+_)
    println(s"reduceLeft, $reduceLeft")
    println(s"stringListResult, $stringLeftResult")

    // reduceRight : foldRight와 유사
    val reduceRight = list2.reduceRight{ _ + _ }
    val stringRightResult = stringList.reduceRight(_+_)
    println(s"reduceRight, $reduceRight")
    println(s"stringRightResult, $stringRightResult")


    val listSum = list2.sum //합
    val listProduct = list2.product // 곱
    val listMax = list2.max // 최댓값
    val listMin = list2.min // 최솟값

    println(s"listSum, $listSum")
    println(s"listProduct, $listProduct")
    println(s"listMax, $listMax")
    println(s"listMin $listMin")


    // "foldLeft/reduceLeft" or "foldRight/reduceRight" 중에
    // "foldLeft/reduceLeft"가 더 사용하기에 유용하다.
    // 재귀, 반복으로 최적화가 되어 있기 때문에. 아래는 그에 해당하는 코드이다.

    val MAX_SIZE = 1000000
    val reduceLeftStartTime = new java.util.Date
    (1 to MAX_SIZE) reduceLeft(_+_)
    val reduceLeftEndTime = new java.util.Date

    val reduceRightStartTime = new java.util.Date
    (1 to MAX_SIZE) reduceRight (_ + _)
    val reduceRightEndTime = new java.util.Date

    println(MAX_SIZE)
    println(s"reduceRightStartTime, $reduceRightStartTime")
    println(s"reduceRightEndTime, $reduceRightEndTime")

    val totalReduceLeftTime = reduceLeftEndTime.getTime - reduceLeftStartTime.getTime
    val totalReduceRightTiem = reduceRightStartTime.getTime - reduceRightStartTime.getTime
    val totalStatement = totalReduceRightTiem > totalReduceLeftTime

    println(s"totalReduceLeftTime, $totalReduceLeftTime")
    println(s"totalReduceRightTime, $totalReduceRightTiem")
    println(s"totalReduceRightTime > totalReduceLeftTime , $totalStatement")

    // transpose : 중첩 리스트에 각 각의 원소의 인덱스 값으로 새로운 리스트를 반환한다
    //  ex) (x1,x2), (y1,y2).traspose = (x1,x2), (y1,y2)
    val list3 = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    val listTranspose = list3.transpose
    println(s"listTranspose, $listTranspose")

    // mkString : 자바에서 보다 문자열 처리를 쉽게 할 수 있다.
    val list4 = List(1,2,3,4,5)
    val listMkString = list.mkString(",")
    val listMkString2 = list.mkString("( " ,"," ,") ")
    println(s"listMkString, $listMkString")
    println(s"listMkString, $listMkString2")

    // addString : StringBuilder에 원하는 추가적인 정보 넣기
    val stringBuilder = new StringBuilder()
    val list5 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    stringBuilder.append("I want all numbers 6-10: ")
    val listFilter = list5.filter( it => it > 5 && it < 11).addString(stringBuilder, ",")
    println(s"stringBuilderr, $list5")
    println(s"listFilter, $listFilter")
  }


  def main(args: Array[String]) {
      traversable1
      traversable2
      traversable3
      traversable4
      collectionToCollection
      traversable5
      traversable6
  }

}
