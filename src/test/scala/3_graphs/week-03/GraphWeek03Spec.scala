package graphs.week03

import collection.mutable.{ListBuffer, Stack}
import org.scalatest._
import graph.week03.BFS

class GraphWeek03Spec extends FlatSpec with Matchers {

  "Graph traver" should " return 2" in {

    val n : Int = 4 // Number of vertices
    val m : Int = 4 // Number of edges

    val s: Int = 2 - 1// Source
    val t: Int = 4 - 1// Target

    // Pairs: u -> v
    val data = List( (1,2), (4,1), (2,3), (3,1) )

    val g : Array[ListBuffer[Int]] = Array.fill( n )(ListBuffer[Int]())

    for (i <- 0 to m - 1) {
      val x = data(i)._1
      val y = data(i)._2
      g(x - 1).append(y - 1)
      g(y - 1).append(x - 1)
    }

    val bfs = new BFS(n)
    bfs.distance(g, s, t) should be (2)
  }

}