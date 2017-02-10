/*
 * Copyright 2014–2017 SlamData Inc.
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

package quasar.pkg

import scala.collection.{ mutable => scm, immutable => sci }
import java.lang.SuppressWarnings

@SuppressWarnings(scala.Array("org.wartremover.warts.MutableDataStructures"))
trait PackageAliases {
  // scala stdlib
  type ->[+A, +B]          = scala.Tuple2[A, B]
  type =?>[-A, +B]         = scala.PartialFunction[A, B]
  type Any                 = scala.Any
  type AnyRef              = scala.AnyRef
  type AnyVal              = scala.AnyVal
  type ArrayBuffer[A]      = scm.ArrayBuffer[A]
  type CTag[A]             = scala.reflect.ClassTag[A]
  type Dynamic             = scala.Dynamic
  type Either[+A, +B]      = scala.util.Either[A, B]
  type EndoA[A]            = A => A
  type ListBuffer[A]       = scm.ListBuffer[A]
  type PairOf[+A]          = A -> A
  type Range               = sci.Range
  type Regex               = scala.util.matching.Regex
  type Some[A]             = scala.Some[A]
  type StringContext       = scala.StringContext
  type Traversable[+A]     = scala.collection.Traversable[A]
  type Try[+A]             = scala.util.Try[A]
  type Vec[+A]             = scala.Vector[A]
  type inline              = scala.inline
  type scIterable[A]       = scala.collection.Iterable[A]
  type scIterator[+A]      = scala.collection.Iterator[A]
  type scMap[K, V]         = scala.collection.Map[K, V]
  type scSeq[A]            = scala.collection.Seq[A]
  type scSet[A]            = scala.collection.Set[A]
  type scTraversable[+A]   = scala.collection.Traversable[A]
  type sciMap[K, +V]       = sci.Map[K, V]
  type sciQueue[+A]        = sci.Queue[A]
  type sciSeq[+A]          = sci.Seq[A]
  type sciTreeMap[K, +V]   = sci.TreeMap[K, V]
  type scmMap[K, V]        = scm.Map[K, V]
  type scmPriorityQueue[A] = scm.PriorityQueue[A]
  type scmSet[A]           = scm.Set[A]
  type smOrdering[A]       = scala.math.Ordering[A]
  type spec                = scala.specialized
  type switch              = scala.annotation.switch
  type transient           = scala.transient
  type unchecked           = scala.unchecked
  type volatile            = scala.volatile
  val +:                   = scala.collection.+:
  val ->                   = scala.Product2
  val :+                   = scala.collection.:+
  val AnyRef               = scala.AnyRef
  val ArrayBuffer          = scm.ArrayBuffer
  val Boolean              = scala.Boolean
  val Double               = scala.Double
  val Left                 = scala.util.Left
  val ListBuffer           = scm.ListBuffer
  val Right                = scala.util.Right
  val Seq                  = sci.Seq
  val Try                  = scala.util.Try
  val Vec                  = scala.Vector
  val scSeq                = scala.collection.Seq
  val sciQueue             = sci.Queue
  val sciTreeMap           = sci.TreeMap
  val scmMap               = scm.HashMap
  val scmPriorityQueue     = scm.PriorityQueue
  val scmSet               = scm.HashSet

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
  val Ord     = scalaz.Order
  val Eq      = scalaz.Equal
}
