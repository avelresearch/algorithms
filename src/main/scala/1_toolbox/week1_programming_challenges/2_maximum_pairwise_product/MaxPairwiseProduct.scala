package toolbox

object MaxPairwiseProduct extends App {

  override def main(args: Array[String]): Unit = {

    val scanner = new java.util.Scanner(System.in)

    val numStr = scanner.nextLine()

    val n : Int = numStr.toInt

    val line = scanner.nextLine()

    val seq: Seq[Int] = ( line.split(" ").map( x => x.toInt) ).toSeq

    val pp = MaxPairwiseProduct(n, seq)

    System.out.print( pp.max() )
  }

}


case class MaxPairwiseProduct(n: Int, s: Seq[Int]) {

  def max() : Int = {
    val si = s.zipWithIndex
    //si.foreach(e1 => si.f(e2 => if (e1._2 == e2._2) 0 else e1._1 * e2._1 ) )
    val r : Seq[Int] = si.map(e1 =>
      si.map(e2 => if (e1._2 == e2._2) 0 else e1._1 * e2._1 )  ).flatten
    r.max
  }

  private def getMax(top: Int, s: Seq[Int]) : Int =
    s.foldLeft(0)( (r: Int, x :Int) => if (x != top && r < x) x else r  )

  def max2() : Int = {
    val t1 = getMax(0, s)
    val t2 = getMax(t1, s)
    t1 * t2
  }

}