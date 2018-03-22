def compute(num : Int) : List[Int] = {
  val coins = List(1, 5, 10)
  var found: List[Int] = List()
  def computeHelper(base: List[Int], acc: Int, searchFor: Int): List[Int] = acc match {
    case y: Int if (y == searchFor) => {
      found = base
      base
    }
    case _ => (for {
      t <- coins
      if (acc + t <= searchFor)
    } yield t).map(h => if (base.length < found.length || found.isEmpty)
      computeHelper(h :: base, acc + h, searchFor) else found).minBy(_.length)
  }
  val divRes : Int = num / 10
  List.fill(divRes)(10) ::: computeHelper(List(), 0, (num - divRes * 10) )
}

compute(127).length
