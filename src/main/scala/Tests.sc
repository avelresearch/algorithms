import scala.collection.mutable.ListBuffer

case class Range(st: Int, en: Int) {

  def ?(e: Int): Boolean = e >= st && e <= en

  def toList: List[Int] = List(st, en)
}


//val ls = List( Range(4, 7), Range(1, 3), Range(2, 5), Range(5, 6) )
val l = List(Range(1, 3), Range(2, 5), Range(3, 6))

val lf = l.flatMap(x => x.toList)

val min = lf.min

val max = lf.max

def maxCover(min: Int, max: Int, ls: List[Range]) = {

//  val r = (min to max)
//    .map(i => ls.map(l => l ? i).count(e => e == true))
//    .max

  val r = (min to max)
    .map(i => ls.map(l => (l ? i, i))
      .filter(e => e._1)
    )

  r.toList
    .map(r => (r.length, r.head._2) )
    .maxBy(_._1)
    ._2
}

val m = maxCover(min, max, l)

//
//def cover(ls: List[Range], acc: List[Int]): List[Int] = ls match {
//  case Nil => acc
//  case s => {
//
//    val lf = s.flatMap(x => x.toList)
//
//    val min = lf.min
//
//    val max = lf.max
//
//    val c = maxCover(min, max, s)
//
//    val res = s.partition(e => e ? c)
//
//    println( s"DEB: $c")
//
//    cover(res._2, c :: acc)
//  }
//}

//val res = cover(l, List() )

