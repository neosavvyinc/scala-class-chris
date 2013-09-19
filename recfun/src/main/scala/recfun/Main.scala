package recfun
import common._

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
    if (r == c || c == 0) 1
    else {
      pascal(c, r - 1) + pascal(c - 1, r - 1)
    }  
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def iter(parens: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) true
      else if (chars.head == '(') iter(parens + 1, chars.tail)
      else if (chars.head == ')') parens > 0 && iter(parens - 1, chars.tail)
      else iter(parens, chars.tail)

    }
    iter(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def iter(moneyIter: Int, coinsIter: List[Int], count: Int): Int = {
      if (moneyIter == 0) 1
      else if (moneyIter < 0 || coinsIter.isEmpty) 0
      else iter(moneyIter, coinsIter.tail, count) + iter(moneyIter - coinsIter.head, coinsIter, count)
    }
    iter(money, coins, 0)
  }
}



