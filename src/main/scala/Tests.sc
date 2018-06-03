val l = List(1, 4, 8)

val capacity = 10

def maxSum(ls : List[Int], acc : Int ) : Int = ls match {
  case h::tail  if (acc + h <= capacity) => maxSum(tail, acc + h)
  case _ => acc
}

l.permutations
  .toList.map(ls => maxSum(ls, 0) )
  .max

//val n = 5
//
//def calcAcc(prev: Int, last: Int, c: Int, acc: Int ) : Int = c match {
//  case v: Int if (v == n) => acc
//  case next: Int => {
//    val current = prev + last
//    calcAcc(last, current, c + 1, current)
//  }
//}
//
//
//
//calcAcc(1, 1, 2, 0)
