package com.toolbox

import org.scalatest._

class KnapsackSpec extends FlatSpec with Matchers {

  "10 3 and 1 4 8" should "return 9" in {

    val p = new Knapsack(10, 3, List(1, 4, 8) )

    val result = p.calc()

    assert(result === 9, "Max amount must be equal 9")
  }

}
