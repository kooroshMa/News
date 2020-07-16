package com.example.rss.base.adapter

import androidx.databinding.ViewDataBinding
import com.example.rss.base.BaseViewModel

open class SingleLayoutAdapter<T, B : ViewDataBinding>(
    private val layoutId: Int,
    items: List<T>,
    viewModel: BaseViewModel? = null,
    onBind: B.(Int) -> Unit = {}
) : BaseAdapter<T, B>(viewModel = viewModel, items = items, onBind = onBind) {

    override fun getLayoutId(viewType: Int): Int = layoutId
}