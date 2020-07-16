package com.example.rss.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rss.base.BaseViewModel
import com.example.rss.BR


abstract class BaseAdapter <T, B : ViewDataBinding>(
    private var itemBindingId: Int = BR.item,
    private var viewModelBindingId: Int = BR.viewModel,
    private var viewModel: BaseViewModel?,
    var items: List<T>,
    var onBind: B.(Int) -> Unit = {}
) : RecyclerView.Adapter<BaseViewHolder<T, B>>() {

    /**
     * get item at given position
     */
    fun getItem(position: Int): T = items[position]

    override fun getItemCount(): Int = items.size

    /**
     * abstract function to decide which layout should be shown at given position.
     * This will be useful for multi layout adapters. for single layout adapter it can only returns
     * a static layout resource id.
     *
     * @return relevant layout resource id based on given position
     *
     */
    abstract fun getLayoutId(viewType: Int): Int

    /**
     * Attempt to create an instance of [BaseViewHolder] with inflated Binding class
     *
     * @param viewType will be used as layoutId for [DataBindingUtil] and will be provided by [getItemViewType]
     *
     * @see [RecyclerView.Adapter.onCreateViewHolder]
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, B> {
        val inflater = LayoutInflater.from(parent.context)
        val binding: B = DataBindingUtil.inflate(inflater, getLayoutId(viewType), parent, false)
        return BaseViewHolder(binding)
    }

    /**
     * Attempt to bind item at given position to holder.
     * And also attempts to invoke [onBind] lambda
     * function on instance of [B] in [BaseViewHolder.binding].
     *
     * @see [RecyclerView.Adapter.onBindViewHolder]
     */
    override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
        holder.bind(itemBindingId, getItem(position), viewModelBindingId, viewModel)
        holder.binding.onBind(position)
    }

    /**
     * Attempts to replace current list of items with newly provided items and notify adapter
     * based on differences of these two lists by [DiffUtil]
     */
    open fun swapItems(newItems: List<T>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition] == newItems[newItemPosition]

            override fun getOldListSize(): Int =
                items.size

            override fun getNewListSize(): Int =
                newItems.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition] == newItems[newItemPosition]
        })
        diffResult.dispatchUpdatesTo(this)

        // newItems.toList() provide a new instance of list with different reference in memory
        // to prevent same instance of objects issues
        items = newItems.toList()
    }

    /**
     * A default interface that can be used as click listener of items
     */
    interface OnItemClickListener<T> {
        fun onItemClick(view: View, item: T, position: Int = -1)
    }
}