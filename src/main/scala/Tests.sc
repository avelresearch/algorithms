// Kruskal algorithm:
// https://www.coursera.org/learn/algorithms-on-graphs/supplement/i6bTE/slides-and-external-references

import com.graphs._

import scala.collection.mutable.ListBuffer
import scala.util.{Failure, Success, Try}

val ds = DisjointSet(1 to 6: _*)

ds.sets

//ds union(1, 2)
//
//ds union(1, 5)
//
//ds union(1, 4)
//
//
//val r = ds.contains(2) && ds.contains(5)
////ds union(2, 5)
//
//
//val s = ds.sets.find(s => s.exists(x => x == 2) && s.exists(y => y == 5) )


case class Edge(from: Int, to: Int, weight: Int)

val N : Int = 6
val es = Array(Edge(1, 2, 4), Edge(2, 3, 8), Edge(3, 6, 1), Edge(4, 1, 2), Edge(5, 4, 3), Edge(6, 5, 9), Edge(1, 5, 1), Edge(2, 6, 6))

val es2 = Array(Edge(1, 2, 4), Edge(1, 4, 2), Edge(1, 5, 1), Edge(2, 5, 5)  )
//val es2 = Array(Edge(1, 2, 4), Edge(1, 4, 2), Edge(1, 5, 1), Edge(2, 5, 5) )

case class Graph(edges: Seq[Edge], n: Int){

  def hasCycle(): Boolean = {

    val ds = DisjointSet(1 to n: _*)

    def travers(es: Seq[Edge], acc: Boolean): Boolean = es match {
      case h :: tail => {
        if (ds.sets.find(s => s.exists(x => x == h.to) && s.exists(y => y == h.from)) == None) {
          ds union(h.from, h.to)
          travers(tail, acc)
        } else true
      }
      case Seq() => acc
    }

    travers(edges, false)
  }


}


//val g = new Graph(es2.toList, 6)

//val r = g.hasCycle()

val lb = new ListBuffer[Edge]()
es.sortBy(_.weight).foreach(eg => {
  val g = new Graph(lb.toList ++ List(eg), N)
  if (!g.hasCycle()) lb.append(eg)
})

val res = lb.toList


//
//val result = Try(es2.foreach(e => {
//  ds union (e.from, e.to)
//}))

//match {
//  case Success(_) => true
//  case Failure(_) => false
//}


//
//// graph with cycle
//
//case class Graph(in: Array[Edge]) {
//
//  val edges = in.toSeq // ++ in.map(e => Edge(e.to, e.from, e.weight)).toSeq
//
//  def hasCycle(): Boolean = {
//
//     def travers(e: Edge, es: Seq[Edge], path: Set[Edge], inCycle : Boolean) : Boolean = es match {
//       case h::tail =>
//
//       case Nil => inCycle
//     }
//
//  }
//
//}
//
//val g = Graph(es2)
//g.hasCycle()