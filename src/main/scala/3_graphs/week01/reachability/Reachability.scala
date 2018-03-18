import java.util.Scanner

import scala.collection.mutable.ListBuffer


object Reachability{

  def main(args: Array[String]): Unit = {

    type Vertex = Int

    val scanner = new Scanner(System.in);

    val n : Int = scanner.nextInt();

    val m : Int = scanner.nextInt();

    val vertexes : Array[ ListBuffer[Vertex] ] = Array.fill(n)( ListBuffer[Vertex]() )
    val visited : Array[Boolean] = new Array[Boolean](n)

    for(i <- 1 to m)
    {
      val x = scanner.nextInt()
      val y = scanner.nextInt()
      vertexes(x - 1).append( y )
      vertexes(y - 1).append( x )
    }

    val vFrom = scanner.nextInt()
    val vTo = scanner.nextInt()

    var found = false
    def explorer(v : Int) : Boolean = {

      def exporerAcc(a: List[Int]) : Boolean = a match {
        case List() => found
        case h::tail => {

          if ( !visited(h - 1) )
            explorer( h )

          if (!found)
            exporerAcc(tail)

          found
        }
      }

      visited.update(v - 1, true)
      if (v == vTo) {
        found = true
        found
      }
      else {
        val n = vertexes(v - 1)
        exporerAcc(n.toList)
      }
    }

    val result = explorer(vFrom)

    if (result) println(1) else println(0);

  }

}

