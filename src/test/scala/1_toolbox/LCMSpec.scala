package toolbox.week2.test

import org.scalatest._
import org.scalatest.concurrent.TimeLimitedTests
import org.scalatest.time.{Millis, Span}
import toolbox.week2.LCM

class LCMSpec extends FlatSpec
  with Matchers with TimeLimitedTests {

  val timeLimit = Span(5, Millis)

  "X=6 and Y=8" should "be  24" in {
    val actual = LCM(6, 8).result
    val expected = 24
    assertResult(expected)(actual)
  }

}
