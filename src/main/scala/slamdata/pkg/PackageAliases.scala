/*
 * Copyright 2020 Precog Data
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

package slamdata.pkg

import scala.{collection => sc}
import scala.collection.{immutable => sci}
import scala.{util => su}

trait PackageAliases {
  // scala stdlib
  type ->[+A, +B]          = scala.Tuple2[A, B]
  type =?>[-A, +B]         = scala.PartialFunction[A, B]
  type Any                 = scala.Any
  type AnyRef              = scala.AnyRef
  type AnyVal              = scala.AnyVal
  type CTag[A]             = scala.reflect.ClassTag[A]
  type Dynamic             = scala.Dynamic
  type Either[+A, +B]      = su.Either[A, B]
  type EndoA[A]            = A => A
  type PairOf[+A]          = A -> A
  type Range               = sci.Range
  type Regex               = su.matching.Regex
  type Some[A]             = scala.Some[A]
  type StringContext       = scala.StringContext
  type Try[+A]             = su.Try[A]
  type Vec[+A]             = scala.Vector[A]
  type inline              = scala.inline
  type scIterator[+A]      = sc.Iterator[A]
  type scMap[K, V]         = sc.Map[K, V]
  type scSet[A]            = sc.Set[A]
  type sciMap[K, +V]       = sci.Map[K, V]
  type sciQueue[+A]        = sci.Queue[A]
  type sciTreeMap[K, +V]   = sci.TreeMap[K, V]
  type smOrdering[A]       = scala.math.Ordering[A]
  type spec                = scala.specialized
  type switch              = scala.annotation.switch
  type transient           = scala.transient
  type unchecked           = scala.unchecked
  type volatile            = scala.volatile

  val +: : sc.+:.type                          = sc.+:
  val -> : scala.Product2.type                 = scala.Product2
  val :+ : sc.:+.type                          = sc.:+
  val AnyRef: scala.AnyRef.type                = scala.AnyRef
  val Boolean: scala.Boolean.type              = scala.Boolean
  val Double: scala.Double.type                = scala.Double
  val Left: su.Left.type                       = su.Left
  val Right: su.Right.type                     = su.Right
  val Try: su.Try.type                         = su.Try
  val Vec: scala.Vector.type                   = scala.Vector
  val sciQueue: sci.Queue.type                 = sci.Queue
  val sciTreeMap: sci.TreeMap.type             = sci.TreeMap

  // java stdlib
  type AtomicInt            = java.util.concurrent.atomic.AtomicInteger
  type AtomicLong           = java.util.concurrent.atomic.AtomicLong
  type BufferedOutputStream = java.io.BufferedOutputStream
  type BufferedReader       = java.io.BufferedReader
  type ByteBuffer           = java.nio.ByteBuffer
  type CharBuffer           = java.nio.CharBuffer
  type Charset              = java.nio.charset.Charset
  type ClassLoader          = java.lang.ClassLoader
  type Comparator[A]        = java.util.Comparator[A]
  type Exception            = java.lang.Exception
  type FileInputStream      = java.io.FileInputStream
  type FileOutputStream     = java.io.FileOutputStream
  type IOException          = java.io.IOException
  type InputStream          = java.io.InputStream
  type InputStreamReader    = java.io.InputStreamReader
  type OutputStream         = java.io.OutputStream
  type OutputStreamWriter   = java.io.OutputStreamWriter
  type PrintStream          = java.io.PrintStream
  type Properties           = java.util.Properties
  type StringBuilder        = java.lang.StringBuilder
  type UUID                 = java.util.UUID
  type jClass               = java.lang.Class[_]
  type jConcurrentMap[K, V] = java.util.concurrent.ConcurrentMap[K, V]
  type jFile                = java.io.File
  type jMapEntry[K, V]      = java.util.Map.Entry[K, V]
  type jPath                = java.nio.file.Path

  // scalaz aliases at present,
  // but also a single place to change implementations
  type Cmp    = scalaz.Ordering
  type Eq[A]  = scalaz.Equal[A]
  type Ord[A] = scalaz.Order[A]
  val Ord: scalaz.Order.type = scalaz.Order
  val Eq: scalaz.Equal.type  = scalaz.Equal
}
