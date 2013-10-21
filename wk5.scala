// MERGE SORT
//
// if a list consists of 0 or 1 elements, it is already sorted
// otherwise:
//
// separate list into two sub-lists, each containing around half of the elements
// sort the two sub-lists
// merge the two sorted sub-lists

def merge(xs: List[Int], ys: List[Int]): List[Int] =
  xs match {
    case Nil => ys
    case x :: xs1 =>
      ys match {
        case Nil => xs
        case y :: ys1 =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
  }

def mergeTuple[T](xs: List[T], ys: List[T])(lt: (T, T) => Boolean): List[T] =
  (xs, ys) match {
    case (Nil, ys) => ys
    case (xs, Nil) => xs
    case (x :: xs1, y :: ys1) => 
      if (lt(x, y)) x :: mergeTuple(xs1, ys)(lt)
      else y :: mergeTuple(xs, ys1)(lt)
  }

def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
  val n = xs.length/2
  if (n == 0) xs
  else {
    val (fst, snd) = xs splitAt n
    mergeTuple(msort(fst)(lt), msort(snd)(lt))(lt)
  }
}

// msort(fruits)((x: String, y: String) => x.compareTo(y) < 0)
// or... 
// import math.Ordering
// def msort[T](xs: List[T])(ord: Ordering): List[T] = {
// Ordering.Int, Ordering.String, etc...
// and call ord.lt(x,y)...
//
// even better, ... (implicit ord: Ordering[T]): ... which 
// figures out type of ordering by itself

def squareList(xs: List[Int]): List[Int] = 
  xs.map(x => x * x)

def squareListPM(xs: List[Int]): List[Int] = xs match {
  case Nil => Nil
  case y :: ys => y * y :: squareListPM(ys)
}

// def posElem(xs: List[Int]): List[Int] = ...
// filter...
def postElem(xs: List[Int]): List[Int] =
  xs.filter(x => x > 0)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 => 
    // take the first set of "same" elements (this is what span does)
    // then concat this list to recursive call of pack with rest of list
    val (first, rest) = xs.span(y => y == x)
    first :: pack(rest)
}

// List(List("a", "a", "a"), List("b", "b"))
// why doesn't this work? it works if it's not parameterized...
// whoops, forgot to parameterize String as T in tuple...
def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs).map((x: List[T]) => (x.head, x.length))

//================================================== 
// reduction of lists : fold/reduce combinators
//================================================== 
