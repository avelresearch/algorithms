package toolbox.test

import toolbox.week3.Change

import org.scalatest._

class ChangeSpec extends FlatSpec with Matchers {

  "For amount 2 minimum change " should "be  2" in {
    val actual = Change( List(1, 5, 10 ) ).compute( 2 )
    val expected = 2
    assertResult(expected)(actual.length)
  }

  "For amount 28 minimum change " should " be 6" in {
    val actual = Change( List(1, 5, 10 ) ).compute( 28 )
    val expected = 6
    assertResult(expected)(actual.length)
  }

}