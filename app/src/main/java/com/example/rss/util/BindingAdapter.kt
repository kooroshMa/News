package com.example.rss.util

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.rss.app.GlideApp


class BindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("srcImageUrl")
        fun setImageSrc(imageView: ImageView, url: String?) {
            if (!url.isNullOrEmpty()) {
                GlideApp.with(imageView.context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView)
            }
        }

        @JvmStatic
        @BindingAdapter("srcImageUrl")
        fun setImageSrcDrawable(imageView: ImageView, drawable: Drawable) {
            GlideApp.with(imageView.context).load(drawable).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("srcImageUrl")
        fun setImageSrcResource(imageView: ImageView, resourceId: Int) {
            GlideApp.with(imageView.context).load(resourceId)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("srcCompat")
        fun setSrcCompatImage(imageView: ImageView, resourceId: Int) {
            imageView.setImageResource(resourceId)
        }

        @BindingAdapter("app:goneUnless")
        fun goneUnless(view: View, visible: Boolean) {
            view.visibility = if (visible) View.VISIBLE else View.GONE
        }
    }
}