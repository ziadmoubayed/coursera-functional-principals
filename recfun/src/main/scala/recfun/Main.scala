package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (r <= 0 || c <= 0 || c >= r) 1
    else (pascal(c - 1, r - 1) + pascal(c, r - 1))
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def split(chars: List[Char], i: Int, j: Int) = {
      val left = chars.slice(0, i)
      val right = chars.slice(j + 1, chars.length)
      left ::: right
    }

    val j = chars.indexOf(')')
    val i = chars.slice(0, j).lastIndexOf('(')
    //this means one exists and the second doesn't
    if (chars.isEmpty || (i == -1 && j == -1)) return true
    else if ((i == -1 && j >= 0) || (i >= 0 && j == -1)) return false
    balance(split(chars, i, j))
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    def change(m: Int, coinList: List[Int], count: Int): Int =
      m match {
        case _ if m < 0 => count
        case _ if coinList.isEmpty => {
          m match {
            case 0 => count + 1
            case _ => count
          }
        }
        case _ => change(m, coinList.tail, count) + change(m - coinList.head, coinList, count)
      }

    change(money, coins, 0)
  }
}
