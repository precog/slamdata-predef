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

package slamdata.pkg

import scala.inline
import scalaz.{ Show, Equal }

final class EqualBy[A] {
  def apply[B](f: A => B)(implicit z: Equal[B]): Equal[A] = z contramap f
}
final class ShowBy[A] {
  def apply[B](f: A => B)(implicit z: Show[B]): Show[A] = Show.show[A](x => z show f(x))
}
final class ExtensionOps[A](private val self: A) {
  @inline def |>[B](f: A => B): B = f(self)
  @inline def ->[B](y: B): (A, B) = scala.Tuple2(self, y)
}
