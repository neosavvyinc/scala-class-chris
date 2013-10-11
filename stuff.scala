import math.abs

object stuff {

  def fib(n: Int): Int = n match {
    case 0 | 1 => n
    case _ => fib(n - 1) + fib(n - 2)
  }
}

object findingFixedPoints {
  val tolerance = 0.0001
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess) 
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1)
  def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

  def sqrtFixedPoint(x: Double) = fixedPoint(averageDamp(y => x / y))(1)

}

//fixedPoint(x => 1 + x/2)(1)

//def sqrt(x: Double) = fixedPoint(y => x / y)(1)
