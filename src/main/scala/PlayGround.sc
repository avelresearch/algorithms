import java.io.{File, PrintWriter}
//def dfs(from: Int, to: Int, N: Int)(implicit graph: Array[(Int, Int)]): Int = {
//  val visited = Array.fill[Int](N)(0)
//
//  def travers(f: Int, acc: Seq[Int]): Seq[Int] = graph.find(p => visited(p._1 - 1) == 0) match {
//    case None => acc
//    case Some((f1, t1)) => {
//      visited(f1 - 0) = 1
//      if (t1 == to) t1 +: acc else travers(t1, f1 +: acc)
//    }
//  }
//
//  val path = travers(from, Seq())
//  println(path.mkString("->"))
//  0
//}
//
//val lb = List((1, 2), (2, 3), (2, 4), (4, 5), (5, 3), (3, 6) )
//
//implicit val graph = lb.toArray
//
//val res = dfs(1, 4, 4)
//
//print("Done")


/*
val writer = new PrintWriter(new File("/Users/pavel/Sources/output.txt"))
writer.write("Hello, world!")
writer.close()
*/

val N = 3000

val nodes = (1 to N).toList
val edges = nodes.zip(nodes.tail )

val wr = new PrintWriter(new File("/Users/pavel/Sources/graph.txt"))
//writer.write("Hello, world!")
wr.write(s"$N ${N- 1}\n")
edges.foreach(node => wr.write(s"${node._1} ${node._2}\n") )
wr.close()