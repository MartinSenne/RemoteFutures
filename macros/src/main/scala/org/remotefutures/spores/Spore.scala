package org.remotefutures.spores

/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2002-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */


//// TODO: complete implementation
//trait NullarySpore[+R] extends Function0[R]
//
//trait Spore[-T, +R] extends Function1[T, R] {
//
//  /** The type of captured variables.
//    *
//    *  If this Spore captures multiple variables, this is
//    *  a tuple type.
//    */
//  type Captured
//
//  /** Enables creating an instance of a Spore subclass via reflection.
//    */
//  def className: String
//
//}
//
//trait SporeWithEnv[-T, +R] extends Spore[T, R] {
//
//  /** Stores the environment of the Spore.
//    *
//    *  If the Spore captures multiple variables, this field
//    *  stores a tuple.
//    */
//  var captured: Captured = _
//
//}
//
//trait SporeC1[-T, +R] extends SporeWithEnv[T, R] {
//  type C1
//  var c1: C1
//}
//
//trait Spore2[-T1, -T2, +R] extends Function2[T1, T2, R]
//
//trait Spore3[-T1, -T2, -T3, +R] extends Function3[T1, T2, T3, R]
//
//class NullarySporeImpl[+R](f: () => R) extends NullarySpore[R] {
//  def apply(): R = f()
//}
//
//class SporeImpl[-T, +R](f: T => R) extends Spore[T, R] {
//  def apply(x: T): R = f(x)
//  def className = "SporeImpl"
//}
//
//class Spore2Impl[-T1, -T2, +R](f: (T1, T2) => R) extends Spore2[T1, T2, R] {
//  def apply(x1: T1, x2: T2): R = f(x1, x2)
//}
//
//class Spore3Impl[-T1, -T2, -T3, +R](f: (T1, T2, T3) => R) extends Spore3[T1, T2, T3, R] {
//  def apply(x1: T1, x2: T2, x3: T3): R = f(x1, x2, x3)
//}

// ======================================

trait NullarySpore[+R] extends Function0[R]

trait Spore[-T, +R] extends Function1[T, R]

trait Spore2[-T1, -T2, +R] extends Function2[T1, T2, R]

trait Spore3[-T1, -T2, -T3, +R] extends Function3[T1, T2, T3, R]

// TODO: clarify if Serializable is fine here

class NullarySporeImpl[+R](f: () => R) extends NullarySpore[R] with Serializable {
  def apply(): R = f()
}

class SporeImpl[-T, +R](f: T => R) extends Spore[T, R] with Serializable {
  def apply(x: T): R = f(x)
}

class Spore2Impl[-T1, -T2, +R](f: (T1, T2) => R) extends Spore2[T1, T2, R] {
  def apply(x1: T1, x2: T2): R = f(x1, x2)
}

class Spore3Impl[-T1, -T2, -T3, +R](f: (T1, T2, T3) => R) extends Spore3[T1, T2, T3, R] {
  def apply(x1: T1, x2: T2, x3: T3): R = f(x1, x2, x3)
}