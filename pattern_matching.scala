// pattern matching... even better solution
// great  fit for problem of decomposition
// 
// better tan OO decomposition, which does not always
// work, due to the need to touch all classes to 
// add a new method

// REVERSE the construction process
//=> which sublcass was used?
//=> what were the arguments of the constructor

trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr

def eval(e: Expr): Int = e match {
  case Number(n) => n
  case Sum(e1, e2) => eval(e1) + eval(e2)
  case Prod(e1, e2) => eval(e1) * eval(e2)
  case _ => throw new Error
}

//=> eval(Sum(Number(1), Number(2))) => 3

// write an expression to a string
def show(e: Expr): String = e match {
  case Number(n) => n.toString
  case Sum(l, r) => eval(l) + " + " + eval(r)
  case Prod(l, r) => eval(l) + " * " + eval(r)
}
