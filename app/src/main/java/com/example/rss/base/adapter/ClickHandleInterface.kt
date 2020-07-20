package com.example.rss.base.adapter

import android.view.View

interface ClickHandleInterface<T> {
    fun click(view: View, items: List<T>, position:Int)
}