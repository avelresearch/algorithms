package graph.week03

import java.util.Scanner
import scala.collection.mutable.ListBuffer

object BFS {

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

    val bfs = new BFS(n)

    val d = bfs.distance(adj, x , y )

    println( d )
  }

}

case class BFS(n: Int) {

  def distance(a: Array[ListBuffer[Int]], s: Int, t: Int) : Int = {

    val dist = Array.fill(n)(Int.MaxValue)
    dist.update(s, 0)

    def distAcc(q: ListBuffer[Int]) : Unit = q match {
      case a if (a.isEmpty) => Unit
      case _ => {
        val u = q.head
        q -= u
        a(u).foreach(v => {
          if (dist(v) == Int.MaxValue) {
            q += v
            dist.update(v, dist(u) + 1)
          }
        });
        distAcc(q)
      }
    }

    val queue : ListBuffer[Int] = ListBuffer(s)
    distAcc(queue)

    if (dist(t) == Int.MaxValue) -1 else dist(t)
  }
}
