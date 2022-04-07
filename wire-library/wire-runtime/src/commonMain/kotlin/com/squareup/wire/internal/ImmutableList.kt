/*
 * Copyright 2013 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire.internal

import kotlin.jvm.JvmName

class ImmutableList<T> private constructor(
  private val list: ArrayList<T>,
) : AbstractList<T>(), RandomAccess, Serializable {
  override val size: Int
    @get:JvmName("size") get() = list.size

  override fun get(index: Int): T = list[index]

  override fun toArray(): Array<Any?> {
    return list.toTypedArray() // Optimizing for mutable copy by MutableOnWriteList.
  }

  @Throws(ObjectStreamException::class)
  private fun writeReplace(): Any = list.toUnmodifiableList()

  companion object {
    private val empty = ImmutableList<Unit>(ArrayList())
    fun <T> empty(): ImmutableList<T> = empty as ImmutableList<T>

    /** Returns an immutable list with the same contents as [list]. */
    fun <T> copyOf(list: List<T>): ImmutableList<T> = ImmutableList(ArrayList(list))

    /**
     * Returns an [ImmutableList] that doesn't perform a defensive copy of [list] and instead just
     * wraps it. This should not be used outside of Wire's own internal codegen.
     */
    fun <T> wrapUnsafe(list: ArrayList<T>): ImmutableList<T> = ImmutableList(list)
  }
}
