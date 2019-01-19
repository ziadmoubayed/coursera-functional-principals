package recfun

object Sqrt extends App {
  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) = {
    Math.abs((x - y) / x) / x < tolerance
  }

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  fixedPoint(x => 1 + x / 2)(1)

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  def sqrt(x: Double) = fixedPoint(x => averageDamp(x => 1 + x / 2)(x))(1)

  val result = sqrt(2)
  println(result)

}
