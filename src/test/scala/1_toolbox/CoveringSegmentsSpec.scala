package com.toolbox

import org.scalatest._

class CoveringSegmentsSpec extends FlatSpec with Matchers {

  "when 3 segments (1,3) (2,5) (3,6) " should "return (3)" in {
    val p = new CoveringSegments(3, List( Range(1,3), Range(2,5), Range(3,6) ) )
    val r = p.calc()
    assert(r == List(3), "Must return value specified" )
  }

  "when 3 segments (4,7) (1,3) (2,5) (5,6) " should "return (3, 6)" in {
    val p = new CoveringSegments(3, List( Range(4,7), Range(1,3), Range(2, 5), Range(5,6) ) )
    val r = p.calc()
    // few solutions possible???
    assert(r == List(3, 6) || r == List(1,5), "Must return value specified" )
  }

}
