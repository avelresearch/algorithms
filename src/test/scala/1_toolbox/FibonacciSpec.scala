package toolbox.week2.test

import org.scalatest._
import org.scalatest.concurrent.TimeLimitedTests
import org.scalatest.time.{Millis, Span}
import toolbox.week2.Fibonacci

class FibonacciSpec extends FlatSpec
  with Matchers with TimeLimitedTests {

  val timeLimit = Span(2, Millis)

  "For 2" should "be  1" in {
    val actual = Fibonacci(1).calc()
    val expected = 1
    assertResult(expected)(actual)
  }


  "For 3" should "be  3" in {
    val actual = Fibonacci(3).calc()
    val expected = 2
    assertResult(expected)(actual)
  }


  "For 4" should "be  3" in {
    val actual = Fibonacci(4).calc()
    val expected = 3
    assertResult(expected)(actual)
  }

  "For 12" should "be  144" in {
    val actual = Fibonacci(12).calc()
    val expected = 144
    assertResult(expected)(actual)
  }

}