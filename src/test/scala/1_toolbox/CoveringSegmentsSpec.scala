package com.toolbox

import org.scalatest._

class CoveringSegmentsSpec extends FlatSpec with Matchers {

  "when 3 segments (1,3) (2,5) (3,6) " should "return 1 and (3)" in {
    val p = new CoveringSegments(3, List( List(1,3), List(2,5), List(3,6) ) )
    val r = p.calc()
    assert(r == (1, List(3) ), "Must return value specified" )
  }
}
