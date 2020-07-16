package com.example.rss.util.extension

import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.google.android.material.tabs.TabLayout
import io.reactivex.Flowable

fun <T> LiveData<T>.toFlowable(lifecycleOwner: LifecycleOwner): Flowable<T> =
    Flowable.fromPublisher(LiveDataReactiveStreams.toPublisher(lifecycleOwner, this))

fun Activity.closeKeyboard() {
    val view = currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun View.closeKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Fragment.toast(message: String) {
    Toast.makeText(context!!, message, Toast.LENGTH_LONG).show()

}

fun TabLayout.applyFont(typeface: Typeface?) {
    val viewGroup = getChildAt(0) as ViewGroup
    val tabsCount = viewGroup.childCount
    for (j in 0 until tabsCount) {
        val viewGroupChildAt = viewGroup.getChildAt(j) as ViewGroup
        val tabChildCount = viewGroupChildAt.childCount
        for (i in 0 until tabChildCount) {
            val tabViewChild = viewGroupChildAt.getChildAt(i)
            if (tabViewChild is TextView) {
                tabViewChild.typeface = typeface
            }
        }
    }
}