package toolbox.week2.test

import org.scalatest._
import org.scalatest.concurrent.TimeLimitedTests
import org.scalatest.time.{Millis, Span}
import toolbox.week2.GCD

class GCDSpec extends FlatSpec
  with Matchers with TimeLimitedTests {

  val timeLimit = Span(30, Millis)


  "X=18 and Y=35" should "be  1" in {
    val actual = GCD(18, 35).result
    val expected = 1
    assertResult(expected)(actual)
  }

  "X=28851538 Y=1183019" should "be  1" in {
    val actual = GCD(28851538,1183019).result
    val expected = 17657
    assertResult(expected)(actual)
  }

}