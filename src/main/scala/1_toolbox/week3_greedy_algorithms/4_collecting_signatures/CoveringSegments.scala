package com.toolbox

object CoveringSegments extends App {


  val ls = List(Range(4, 7), Range(1, 3), Range(2, 5), Range(5, 6))

  val p = new CoveringSegments(4, ls)

  val res = p.calc()

}

case class Range(st: Int, en: Int) {

  def ?(e: Int): Boolean = e >= st && e <= en

  def toList: List[Int] = List(st, en)
}

case class CoveringSegments(count: Int, segments: List[Range]) {

  def calc(): List[Int] = cover(segments, List())


  def maxCover(min: Int, max: Int, ls: List[Range]): Int = {

    val r = (min to max)
      .map(i => ls.map(l => (l ? i, i))
        .filter(e => e._1)
      )

    r.toList
      .map(r => (r.length, r.head._2) )
      .maxBy(_._1)
      ._2

  }

  def cover(ls: List[Range], acc: List[Int]): List[Int] = ls match {
    case Nil => acc
    case s => {

      val lf = s.flatMap(x => x.toList)

      val min = lf.min

      val max = lf.max

      val c = maxCover(min, max, s)

      val res = s.partition(e => e ? c)

      cover(res._2, c :: acc)
    }
  }

}
