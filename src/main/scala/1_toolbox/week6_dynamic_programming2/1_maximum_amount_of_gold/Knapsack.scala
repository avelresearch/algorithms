package com.toolbox

object Knapsack extends App {

    println("Test ..")
}

case class Knapsack(count: Int, capacity: Int, bars : List[Int]) {

    def maxSum(ls : List[Int], acc : Int ) : Int = ls match {
        case h::tail  if (acc + h <= capacity) => maxSum(tail, acc + h)
        case _ => acc
    }

    def calc() : Int =
        bars.permutations
          .toList.map(ls => maxSum(ls, 0) )
          .max


}

