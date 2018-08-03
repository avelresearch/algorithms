import java.io.{BufferedReader, InputStreamReader}
import java.util.StringTokenizer

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Reachability2 {

  private class FastScanner() {
    var tok = new StringTokenizer("")
    var bin = new BufferedReader(new InputStreamReader(System.in))

    def next(): String = {
      while (!tok.hasMoreElements())
        tok = new StringTokenizer(bin.readLine());
      return tok.nextToken();
    }
  }

  case class Edge(from: Int, to: Int)

  // True - if Graph contains cycle
  // False - if Graph has no cycle
  def dfs(from: Int, N: Int)(implicit graph: Seq[Edge]): Boolean = {

    val paths = new ListBuffer[Seq[Edge]]()
    val vertex = Array.fill[Int](N)(0)
    var flag: Int = 1
    var hasCycle = false

    def pexists(a: Seq[Edge], e: Edge): Boolean = a.find(p => p.from == e.from && p.to == e.to) != None

    @tailrec
    def travers(f: Int, g: List[Edge], acc: Seq[Edge]): Seq[Edge] = g match {
      case Nil => { vertex(f - 1) = 0; acc }
      case h::tail =>
        if (hasCycle == false & h.from == f && vertex(h.from - 1) == 0)
          travers(h.to, graph.toList, {
            if (pexists(acc, h) )
              hasCycle = true
            acc :+ h})
      else travers(f, tail, acc)
    }
    travers(from, graph.toList, Seq())
    hasCycle
  }

  //val lb =  List( Edge(1, 2), Edge(2, 3), Edge(2, 4), Edge(2, 5), Edge(4, 5), Edge(5, 3), Edge(3, 6), Edge(6,8), Edge(2, 7), Edge(8, 7), Edge(4, 10), Edge(7, 9), Edge(9, 11), Edge(10, 11) )
  //val lb =  List( Edge(1, 2), Edge(2,3), Edge(2, 4), Edge(5, 3), Edge(4, 5), Edge(6, 5), Edge(4, 7), Edge(7, 6) )
  //val lb = List(Edge(1, 2), Edge(2, 3), Edge(3, 4) )
  //val lb = List(Edge(1, 2), Edge(2, 5), Edge(2, 4), Edge(4, 5), Edge(5, 3), Edge(3, 6) )
  //val lb = List(Edge(4, 3), Edge(1, 2), Edge(4, 1), Edge(3, 1))
  //implicit val graph = lb

  def main(args: Array[String]): Unit = {

    val scanner = new FastScanner()
    val (n, m) = (scanner.next().toInt, scanner.next().toInt)
    implicit val graph = (1 to m).map(_ => (scanner.next().toInt, scanner.next().toInt)).map(p => Edge(p._1, p._2))

    //dfs(graph.last.from, n)
    val isAcyclicGraph = graph.zipWithIndex.forall(node => {
      println(node._2)
      dfs(node._1.from, n) == false
    })
    if (isAcyclicGraph) println("Does not contains cycle")
    else println("Contains cycle")

  }
}
