import scala.annotation.tailrec

@tailrec
def factorial(x: Int): Int = {
  def loop(acc: Int, value: Int): Int = {
    if (value == 0) 1
    else loop(acc * value, value - 1)
  }
  loop(1, x)
}

factorial(0)
factorial(1)
factorial(2)
factorial(3)