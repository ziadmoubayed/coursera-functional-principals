package funsets

object IntSet {

}

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty(), new Empty())
  def contains(x: Int): Boolean = false
  def union(other: IntSet): IntSet = other
}

class NonEmpty(x: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int): IntSet = {
    if (this.x < x) new NonEmpty(this.x, left incl x, right)
    else if (this.x > x) new NonEmpty(this.x, left, right incl x)
    else this
  }

  def contains(x: Int): Boolean = {
    if (this.x < x) left contains x
    if (this.x > x) right contains x
    else true
  }

  def union(other: IntSet): IntSet = {

  }
}