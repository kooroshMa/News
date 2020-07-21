package com.example.rss.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

inline fun <T1, T2, R> combine(
    source1: LiveData<T1>,
    source2: LiveData<T2>,
    crossinline combine: (data1: T1?, data2: T2?) -> R
): MutableLiveData<R> = MediatorLiveData<R>().apply {

    var data1: T1? = null
    var data2: T2? = null

    addSource(source1) {
        data1 = it
        value = combine(data1, data2)
    }

    addSource(source2) {
        data2 = it
        value = combine(data1, data2)
    }

}