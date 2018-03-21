package toolbox.week3

  case class Change(coins: List[Int]) {

    def compute(base: List[Int], acc: Int, searchFor: Int): List[Int] = {
      acc match {
        case y: Int if (y == searchFor) => base
        case _ => {
          {
            for {
              coin <- coins
              if (acc + coin <= searchFor)
            } yield coin
          }.map(h => compute(h :: base, acc + h, searchFor))
          .minBy(_.length)
        }
      }
    }

  }