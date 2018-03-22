package toolbox.week2

case class Fibonacci(n: Int) {

  def calc(): Int = {

    def calcAcc(prev: Int, last: Int, c: Int, acc: Int ) : Int = c match {
      case v: Int if (v == n) => {
        println(acc)
        acc
      }
      case next: Int => {
        val current = prev + last
        calcAcc(last, current, c + 1, current)
      }
    }

    n match {
      case x : Int if (x == 1) => 1
      case x : Int if (x == 2) => 1
      case _ => calcAcc(1, 1, 2, 0)
    }

  }

}