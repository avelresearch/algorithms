package toolbox.week2

import scala.annotation.tailrec

case class GCD(x: Int, y:Int) {

  @tailrec
  private def calcAcc(a: Int, b:Int): Int =
    if (a == 0) b else calcAcc(b % a, a)

  lazy val result : Int = calcAcc(x, y)
}
