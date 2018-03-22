val n = 5

def calcAcc(prev: Int, last: Int, c: Int, acc: Int ) : Int = c match {
  case v: Int if (v == n) => acc
  case next: Int => {
    val current = prev + last
    calcAcc(last, current, c + 1, current)
  }
}



calcAcc(1, 1, 2, 0)
