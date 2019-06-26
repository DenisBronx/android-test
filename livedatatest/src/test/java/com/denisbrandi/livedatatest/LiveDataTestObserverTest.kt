package com.denisbrandi.livedatatest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import org.junit.Rule
import org.junit.Test

class LiveDataTestObserverTest {

    @Rule
    @JvmField
    val liveDataRule = InstantTaskExecutorRule()

    @Test
    fun assertEmpty() {
        val liveData = MutableLiveData<Any>()
        val liveDataTestObserver = liveData.test()

        liveDataTestObserver.assertEmpty()
    }

    @Test
    fun assertValue() {
        val value = Any()
        val liveData = MutableLiveData<Any>()
        val liveDataTestObserver = liveData.test()

        liveData.value = value


        liveDataTestObserver.assertValue(value)
    }

    @Test
    fun assertValues() {
        val value1 = Any()
        val value2 = Any()
        val liveData = MutableLiveData<Any>()
        val liveDataTestObserver = liveData.test()

        liveData.value = value1
        liveData.value = value2

        liveDataTestObserver.assertValues(value1, value2)
    }
}