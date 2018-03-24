package toolbox.week2

import scala.annotation.tailrec

case class LCM(x: Int, y:Int) {

  @tailrec
  private def calcGCDAcc(a: Int, b:Int): Int =
    if (a == 0) b else calcGCDAcc(b % a, a)

  lazy val result : Int =
    math.abs(x * y) /  calcGCDAcc(x, y)
}
