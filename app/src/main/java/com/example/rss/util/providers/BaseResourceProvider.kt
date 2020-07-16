package com.example.rss.util.providers

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface BaseResourceProvider {

    fun getString(@StringRes id: Int): String

    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String

    fun getColor(@ColorRes resId: Int): Int

    fun getDrawable(@DrawableRes resId: Int): Drawable?

    fun getBitmapFromVectorDrawable(@DrawableRes drawableId: Int): Bitmap
}
