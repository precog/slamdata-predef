/*
 * Copyright 2014–2019 SlamData Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package slamdata

import org.scalactic.source.Position
import scala.NotImplementedError
import scala.annotation.unchecked.uncheckedVariance
import scala.reflect.runtime.universe.WeakTypeTag

import scala.{Predef => P}
import scala.{collection => C}
import scala.collection.{immutable => I}
import scala.{math => M}
import scala.{runtime => R}

object Predef extends Predef

class Predef
    extends LowPriorityImplicits
    with    slamdata.pkg.PackageAliases
    with    slamdata.pkg.PackageMethods {
  type deprecated = scala.deprecated
  type tailrec = scala.annotation.tailrec
  type SuppressWarnings = java.lang.SuppressWarnings

  type Array[T]                = scala.Array[T]
  val  Array: scala.Array.type = scala.Array

  type Boolean = scala.Boolean
  type Byte = scala.Byte
  type Char = scala.Char
  type Double = scala.Double

  val  Function: scala.Function.type = scala.Function

  type Short                   = scala.Short
  val  Short: scala.Short.type = scala.Short

  type Int                 = scala.Int
  val  Int: scala.Int.type = scala.Int

  type Long                  = scala.Long
  val  Long: scala.Long.type = scala.Long

  type PartialFunction[-A, +B]                     = scala.PartialFunction[A, B]
  val  PartialFunction: scala.PartialFunction.type = scala.PartialFunction

  type String = P.String

  val  StringContext: scala.StringContext.type = scala.StringContext

  type Symbol                    = scala.Symbol
  val  Symbol: scala.Symbol.type = scala.Symbol

  type Unit = scala.Unit

  type Vector[+A]                = scala.Vector[A]
  val  Vector: scala.Vector.type = scala.Vector

  type BigDecimal                    = M.BigDecimal
  val  BigDecimal: M.BigDecimal.type = M.BigDecimal

  type BigInt                = M.BigInt
  val  BigInt: M.BigInt.type = M.BigInt

  type IndexedSeq[+A] = C.IndexedSeq[A]

  type ListMap[A, +B]          = I.ListMap[A, B]
  val  ListMap: I.ListMap.type = I.ListMap

  type Map[A, +B]      = I.Map[A, B]
  val  Map: I.Map.type = I.Map

  type Set[A]          = I.Set[A]
  val  Set: I.Set.type = I.Set

  type Seq[+A] = I.Seq[A]

  // better type hole
  private type UnsafeWeakTypeTag[+A] = WeakTypeTag[A @uncheckedVariance]

  @SuppressWarnings(Array(
    "org.wartremover.warts.Throw",
    "org.wartremover.warts.ImplicitParameter"))
  def ???[A](implicit A: UnsafeWeakTypeTag[A], pos: Position): A =
    throw new NotImplementedError(s"unimplemented value of type ${A.tpe} at ${pos.fileName}:${pos.lineNumber}")

  implicit def genericArrayOps[T] = P.genericArrayOps[T] _

  @inline implicit def wrapString(x: String): I.WrappedString    = P.wrapString(x)
  @inline implicit def booleanWrapper(x: Boolean): R.RichBoolean = P.booleanWrapper(x)
  @inline implicit def charWrapper(x: Char): R.RichChar          = P.charWrapper(x)
  @inline implicit def intWrapper(x: Int): R.RichInt             = P.intWrapper(x)
  @inline implicit def doubleWrapper(x: Double): R.RichDouble    = P.doubleWrapper(x)

  // would rather not have these, but …
  def print(x: scala.Any): Unit   = scala.Console.print(x)
  def println(x: scala.Any): Unit = scala.Console.println(x)
  // Need these often to avoid bad inference
  type Product = scala.Product
  type Serializable = scala.Serializable

  // remove or replace these
  type List[+A]          = I.List[A] // use scalaz.IList instead
  val  List: I.List.type = I.List
  val  Nil: I.Nil.type   = I.Nil
  val  :: : I.::.type    = I.::
  type Option[A]                 = scala.Option[A] // use scalaz.Maybe instead
  val  Option: scala.Option.type = scala.Option
  val  None: scala.None.type     = scala.None
  val  Some: scala.Some.type     = scala.Some
  type Nothing = scala.Nothing // make functors invariant
  type Throwable = java.lang.Throwable
  type RuntimeException = java.lang.RuntimeException
}

abstract class LowPriorityImplicits {
  self: Predef =>

  @inline implicit def augmentString(x: String): I.StringOps               = P.augmentString(x)
  implicit def genericWrapArray[T](x: Array[T])                            = P.genericWrapArray[T](x)
}
