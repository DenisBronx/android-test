package com.denisbrandi.livedatatest

import androidx.lifecycle.LiveData

fun <T> LiveData<T>.test() = LiveDataTestObserver(this)