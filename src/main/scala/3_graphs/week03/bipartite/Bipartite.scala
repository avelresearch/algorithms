package graph.week03

import java.util.Scanner
import scala.collection.mutable.ListBuffer

object Bipartite {

  def main(args: Array[String]): Unit = {

    val scanner = new Scanner(System.in);

    val n: Int = scanner.nextInt()
    val m: Int = scanner.nextInt()

    val adj: Array[ListBuffer[Int]] = Array.fill(n)(ListBuffer[Int]())

    if (m > 0) {
      for (i <- 1 to m) {
        val x = scanner.nextInt()
        val y = scanner.nextInt()
        adj(x - 1).append(y - 1)
        adj(y - 1).append(x - 1)
      }
    }

    val x: Int = scanner.nextInt() - 1
    val y: Int = scanner.nextInt() - 1

    val bfs = new Bipartite(n)

    val d = bfs.valid(adj, x , y )

    println( d )
  }

}

case class Bipartite(n: Int) {

  def valid(a: Array[ListBuffer[Int]], s: Int, t: Int) : Boolean = ???

}
