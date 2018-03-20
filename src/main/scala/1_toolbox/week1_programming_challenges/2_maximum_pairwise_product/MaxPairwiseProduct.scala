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

}