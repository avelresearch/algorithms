package toolbox.test

import toolbox.MaxPairwiseProduct

import org.scalatest._

class MaxPairwiseProductSpec extends FlatSpec with Matchers {

  "Max for Seq(1 2 3)" should " be 6 " in {

    val s = Seq(1, 2, 3)

    val pp = MaxPairwiseProduct( s.length, s)

    assertResult( 6 )( pp.max() )
  }

}