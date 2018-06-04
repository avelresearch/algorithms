package com.toolbox

import org.scalatest._

class LargestNumberSpec extends FlatSpec with Matchers {

  "when 5 numbers  9 4 6 1 9" should "return 99641" in {
    val p = new LargestNumber(5, List(9, 4, 6, 1, 9) )
    val r = p.calc()
    assert(r === 99641, "Max number must be return 99641")
  }

  "when 3 numbers 23 39 92 " should "return 923923" in {
    val p = new LargestNumber(3, List(23, 39, 92) )
    val r = p.calc()
    assert(r === 923923, "Max number must be return 923923")
  }

  "when 2 numbers 21 2 " should "return 212" in {
    val p = new LargestNumber(2, List(21, 2) )
    val r = p.calc()
    assert(r === 212, "Max number must be return 212")
  }

}
