package com.toolbox

object  LargestNumber extends App {
  println("TestApp...")
}

case class LargestNumber(count: Int, digits: List[Int]){

  def calc() : Int =
    digits.sortWith( (a, b) => a > b).mkString("").toInt

}
