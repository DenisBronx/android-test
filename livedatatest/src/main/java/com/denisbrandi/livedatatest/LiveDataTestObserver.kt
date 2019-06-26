package com.denisbrandi.livedatatest

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.LiveData
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals

class LiveDataTestObserver<T>(liveData: LiveData<T>) {

    private val sequence = mutableListOf<T>()

    init {
        val lifecycle = LifecycleRegistry(mock {})
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        liveData.observe({ lifecycle }) { nullableObject ->
            nullableObject?.let { sequence.add(it) }
        }
    }

    fun assertEmpty() {
        assertEquals(sequence.size, 0)
    }

    fun assertValue(value: T) {
        assertEquals(sequence.size, 1)
        assertEquals(sequence[0], value)
    }

    fun assertValues(vararg values: T) {
        assertEquals(sequence.size, values.size)
        assertSequence(values.toList())
    }

    private fun assertSize(values: List<T>) {
        assertEquals(sequence.size, values.size)
    }

    private fun assertSequence(values: List<T>) {
        for (i in 0 until values.size) {
            assertEquals(sequence[i], values[i])
        }
    }

}