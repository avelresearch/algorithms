// Kruskal algorithm:
// https://www.coursera.org/learn/algorithms-on-graphs/supplement/i6bTE/slides-and-external-references

import scala.collection.mutable

class DSet[A]{

  import DSet.Node

  private[this] val parent = mutable.Map.empty[A, Node[A]]

  private[this] implicit def toNode(x: A) = {
    assume( ?(x) )
    parent(x)
  }

  def ?(x: A) : Boolean = parent contains x
  def ??(x: A) : Boolean = ! (parent contains x)


  def +=(x: A) = {
    assume( ??(x) )
    parent(x) = new Node[A](x)
  }

}

object DSet {

  private[DSet] class Node[A](entry: A) {

    var (parent) = (this)

    def root: Node[A] = {
      if (parent != this)
        parent = parent.root
      parent
    }

  }

}


//import com.graphs._
//
//import scala.collection.mutable.ListBuffer
//
//case class Edge(from: Int, to: Int, weight: Int)
//
//val N : Int = 6
//val es = Array(Edge(1, 2, 4), Edge(2, 3, 8), Edge(3, 6, 1), Edge(4, 1, 2), Edge(5, 4, 3), Edge(6, 5, 9), Edge(1, 5, 1), Edge(2, 6, 6))
//
//val es2 = Array(Edge(1, 2, 4), Edge(1, 4, 2), Edge(1, 5, 1), Edge(2, 5, 5)  )
////val es2 = Array(Edge(1, 2, 4), Edge(1, 4, 2), Edge(1, 5, 1), Edge(2, 5, 5) )
//
//case class Graph(edges: Seq[Edge], n: Int){
//
//  def hasCycle(): Boolean = {
//
//    val ds = DisjointSet(1 to n: _*)
//
//    def travers(es: Seq[Edge], acc: Boolean): Boolean = es match {
//      case h :: tail => {
//        if (ds.sets.find(s => s.exists(x => x == h.to) && s.exists(y => y == h.from)) == None) {
//          ds union(h.from, h.to)
//          travers(tail, acc)
//        } else true
//      }
//      case Seq() => acc
//    }
//
//    travers(edges, false)
//  }
//
//
//}
//
//val lb = new ListBuffer[Edge]()
//es.sortBy(_.weight).foreach(eg => {
//  val g = new Graph(lb.toList ++ List(eg), N)
//  if (!g.hasCycle()) lb.append(eg)
//})
//
//val res = lb.toList
//
//val totalWeight = res.map(_.weight).sum