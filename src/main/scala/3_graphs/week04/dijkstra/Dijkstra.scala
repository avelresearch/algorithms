import java.util.Scanner
import scala.collection.mutable.ListBuffer

object Dijkstra {

  def main(args: Array[String]): Unit = {

    val scanner = new Scanner(System.in);

    val (n: Int, m: Int) = ( scanner.nextInt(), scanner.nextInt() )

    val adj: Array[ListBuffer[Int]] = Array.fill(n)(ListBuffer[Int]())

    val cost: Array[ListBuffer[Int]] = Array.fill(n)(ListBuffer[Int]())

    if (m > 0) {
      for (i <- 1 to m) {
        val (x, y, w) = ( scanner.nextInt(), scanner.nextInt(),  scanner.nextInt() )
        adj(x - 1).append(y - 1)
        cost(x - 1).append(w)
      }
    }

    val (x, y) = ( scanner.nextInt() - 1, scanner.nextInt() - 1 )

    val   INFINITY    = Int.MaxValue / 2
    val   UNDEFINED   = Int.MaxValue / 5
    type  QueueItem = (Int, Int)

    case class Queue(s: Int){

      def isEmpty = items.isEmpty

      val items : ListBuffer[QueueItem] = List.fill(n)().zipWithIndex.map(v => if (s != v._2) (v._2, INFINITY) else (s, 0) ).to

      def changePriority(v: Int, alt: Int) : Unit = {
        val i = items.find(x => x._1 == v)
        i match {
          case None => items.append( (v, alt) )
          case Some(a) => {
            items -= a
            items.append((a._1, alt))
          }
        }
      }

      def extractMin() : Int = {
        val m = items.map(x => x._2).min
        items.find(p => p._2 == m) match {
          case None => -1
          case Some( v ) => {
            items -= v
            v._1
          }
        }
      }
    }

    def distance(a: Array[ListBuffer[Int]], c : Array[ListBuffer[Int]], s: Int, t: Int) : Int = {

      val dist:Array[Int] = Array.fill(n)(INFINITY)
      val prev:Array[Int] = Array.fill(n)(INFINITY)

      val queue = Queue( s )

      def relax(adjU: List[Int], costU: List[Int], u: Int ) : Unit = adjU match {
        case List() => Unit
        case v::tail => {
          val alt : Int = costU.head + dist(u)
          if ( alt < dist(v) )
          {
            dist(v) = alt
            prev(v) = u
            queue.changePriority(v, alt)
          }
          relax(tail, costU.tail, u)
        }
      }

      dist(s) = 0

      while( queue.isEmpty == false)
      {
        val u = queue.extractMin()
        relax( adj(u).toList, cost(u).toList, u )
      }

      if (dist(t) != INFINITY) dist(t) else -1
    }

    val d = distance(adj, cost, x, y)
    
    println( d )
  }

}
