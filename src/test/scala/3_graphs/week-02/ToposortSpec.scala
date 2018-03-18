import graph.week02.Toposort

import collection.mutable.{ListBuffer, Stack}
import org.scalatest._

class ToposortSpec extends FlatSpec with Matchers {

  "Order for the graph" should " be: [4, 3, 1, 2] " in {

    val n : Int = 4 // Number of vertices
    val m : Int = 3 // Number of edges

    // Pairs: u -> v
    val data = List( (1,2), (4,1), (3,1) )

    val g : Array[ListBuffer[Int]] = Array.fill( n )(ListBuffer[Int]())
    val ig: Array[ListBuffer[Int]] = Array.fill(n)( ListBuffer[Int]())

    for (i <- 0 to m - 1) {
      val x = data(i)._1
      val y = data(i)._2
      g(x - 1).append(y - 1)
      ig(y - 1).append(x - 1)
    }

    val obj = new Toposort()

    obj.toposort(g, ig) should be ( List(4, 3, 1, 2) )
  }

}