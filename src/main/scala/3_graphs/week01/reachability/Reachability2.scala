import java.io.{BufferedReader, InputStreamReader}
import java.util.StringTokenizer

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

    def pathExists(a: Seq[Edge], e: Edge): Boolean = a.find(p => p.from == e.from && p.to == e.to) != None

    def travers(f: Int, acc: Seq[Edge]): Seq[Edge] = {
      val xs = for {
        edge <- graph
        if (hasCycle == false)
        if (edge.from == f && vertex(edge.from - 1) == 0)
        // Check if we found required vertex
        //if (edge.to != to)
        //if (edge.to != from)
        ls <- travers(edge.to, {
          if (pathExists(acc, edge)) {
            hasCycle = true; acc
          } else edge +: acc
        })
      } yield ls
      if (xs.nonEmpty) xs
      else {
        vertex(f - 1) = flag;
        flag = flag + 1;
        paths.append(acc)
        acc
      }
    }

    travers(from, Seq())
    //paths.foreach(p => println(p.reverse.mkString("->")))
    hasCycle

    //println( path.mkString("->") )
    //val res : Seq[Edge] = paths.toList.distinct.flatMap(e => e.reverse)
    //println( res.mkString("->") )
    //paths.foreach(p => println(p.reverse.mkString("->")))
    //println( path mkString("->") )
    //path exists(e => e.to == to)
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
    implicit val graph = (1 to m).map(_ => (scanner.next().toInt, scanner.next().toInt) ).map(p => Edge(p._1, p._2) )

    val isAcyclicGraph = graph.forall(node => dfs(node.from, n) == false)
    if (isAcyclicGraph) println("Does not contains cycle")
    else println("Contains cycle")

  }
}
