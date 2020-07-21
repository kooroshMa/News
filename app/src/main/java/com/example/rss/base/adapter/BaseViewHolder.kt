package com.example.rss.base.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.rss.base.BaseViewModel

class BaseViewHolder <in T, out B : ViewDataBinding>(val binding: B) : RecyclerView.ViewHolder(binding.root) {

    /**
     * binding method that bind data model to [ViewDataBinding] class
     *
     * @param itemBindingId Generated item binding id that will should be founded in BR class.
     * @param item an instance of [T] to be shown in layout
     */
    fun bind(itemBindingId: Int, item: T, viewModelBindingId: Int, viewModel: BaseViewModel?) {
        binding.setVariable(itemBindingId, item)
        if (viewModel != null)
            binding.setVariable(viewModelBindingId, viewModel)
        binding.executePendingBindings()
    }
}