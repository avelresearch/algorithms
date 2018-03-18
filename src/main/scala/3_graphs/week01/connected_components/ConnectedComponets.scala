import java.util.Scanner
import scala.collection.mutable.ListBuffer

object ConnectedComponets
{

  def main(args: Array[String]): Unit = {

    type Vertex = Int

    val scanner = new Scanner(System.in);

    val n : Int = scanner.nextInt();

    val m : Int = scanner.nextInt();

    val vertexes : Array[ ListBuffer[Vertex] ] = Array.fill(n)( ListBuffer[Vertex]() )
    val visited : Array[Int] = new Array[Int](n)

    for(i <- 1 to m)
    {
      val x = scanner.nextInt()
      val y = scanner.nextInt()
      vertexes(x - 1).append( y )
      vertexes(y - 1).append( x )
    }

    var flag = 1

    def explorer(v : Int) : Boolean = {

      def exporerAcc(a: List[Int]) : Boolean = a match {
        case List() => true
        case h::tail => {
          if ( visited(h - 1) == 0)
            explorer( h )
          exporerAcc(tail)
        }
      }

      visited.update(v - 1, flag)

      val n = vertexes(v - 1).filter(x => visited(x - 1) == 0)
      if (n.length > 0)
        exporerAcc(n.toList)
      else
        false
    }

    var ready : Boolean = false
    var vertex : Int = 1

    while(ready == false){

      explorer(vertex)

      ready = visited.forall(x => x > 0)

      if (!ready) {
        vertex = visited.zipWithIndex.filter(x => x._1 == 0)(0)._2 + 1
        flag = flag + 1
      }
    }

    println(flag)

  }

}
