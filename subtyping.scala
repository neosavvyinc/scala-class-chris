
// liskov substitution principle =>
//
// if A is a subtype of B, everything you
// can do with B should also be able to be
// done with type A

// <: IntSet is an upper bound of the type parameter S
// it means that S can be instantiated only to types
// that conform to IntSet
//
// generally, S is a subtype of IntSet
// def assertAllPos[S <: IntSet](r: S): S = …

// Given NonEmpty <: IntSet
// is
// List[NonEmpty] <: List[IntSet] ?
//
// if true, this is COVARIANT (remember [+A] type in
// func prog in scala book)

// Arrays are NOT covariant
