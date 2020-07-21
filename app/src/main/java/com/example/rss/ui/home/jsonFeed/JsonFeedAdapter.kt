package com.example.rss.ui.home.jsonFeed

import androidx.databinding.ViewDataBinding
import com.example.rss.base.BaseViewModel
import com.example.rss.base.adapter.BaseAdapter
import com.example.rss.base.adapter.BaseViewHolder
import com.example.rss.base.adapter.ClickHandleInterface
import com.example.rss.domain.model.jsonFeed.ArticleModel
import kotlinx.android.synthetic.main.item_json_feed.view.*

class JsonFeedAdapter<T, B : ViewDataBinding>(
    private val layoutId: Int,
    items: List<T>,
    val viewModel: BaseViewModel? = null,
    onBind: B.(Int) -> Unit = {},
    val clickHandleInterface: ClickHandleInterface<T>
) : BaseAdapter<T, B>(viewModel = viewModel, items = items, onBind = onBind) {

    var onItemClick: ((articleModel: ArticleModel) -> Unit)? = null

    override fun getLayoutId(viewType: Int): Int = layoutId

    override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.itemView.img_favorite_en.setOnClickListener {
            clickHandleInterface.click(it, items, position)
        }

        holder.itemView.card_itemContainer.setOnClickListener {
            onItemClick?.invoke(getItem(position).let {
                it as ArticleModel
            })
        }
    }
}