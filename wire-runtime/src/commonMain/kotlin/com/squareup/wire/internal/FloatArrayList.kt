/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */
package com.squareup.wire.internal

/**
 * Offers a nice wrapper around FloatArray, that handles resizing the underlying array as needed and
 * provides a trimToSize() method to truncate the underlying array to the current number of elements.
 */
class FloatArrayList(initialCapacity: Int) {
  private var data = FloatArray(initialCapacity)
  private var size = 0

  /**
   * Returns the underlying FloatArray, truncating as necessary so that the returned array has
   * the same size as the number of elements in it.
   *
   * Because this method truncates the underlying array, it should only be called after all
   * elements have been added to the list, otherwise the next call to add() will cause the
   * array to be resized.
   */
  fun toArray(): FloatArray {
    if (size < data.size) {
      data = data.copyOf(size)
    }
    return data
  }

  fun add(float: Float) {
    ensureCapacity(size + 1)
    data[size++] = float
  }

  fun isNotEmpty() : Boolean = size > 0

  private fun ensureCapacity(minCapacity: Int) {
    if (minCapacity > data.size) {
      data = data.copyOf(maxOf(data.size * 3 / 2 + 1, minCapacity))
    }
  }


  override fun toString(): String = data.copyOf(size).contentToString()

  companion object {
    fun forDecoding(
      minLengthInBytes: Long,
      minimumElementByteSize: Long,
    ) : FloatArrayList {
      val minElements = (minLengthInBytes / minimumElementByteSize)
        .coerceAtMost(Int.MAX_VALUE.toLong())
        .toInt()
      return FloatArrayList(minElements)
    }
  }
}
