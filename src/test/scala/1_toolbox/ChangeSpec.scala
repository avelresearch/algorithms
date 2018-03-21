package toolbox.test

import toolbox.week3.Change

import org.scalatest._

class ChangeSpec extends FlatSpec with Matchers {

  "For amount 2" should " be 2" in {
    val actual = Change( List(1, 5, 10) ).compute( List(), 0, 2)
    val expected = 2
    assertResult(expected)(actual.length)
  }

}