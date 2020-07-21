package com.example.rss.ui.home.xmlFeed

import androidx.databinding.ViewDataBinding
import com.example.rss.base.BaseViewModel
import com.example.rss.base.adapter.BaseAdapter
import com.example.rss.base.adapter.BaseViewHolder
import com.example.rss.base.adapter.ClickHandleInterface
import com.example.rss.domain.model.xmlFeed.DetailModel
import kotlinx.android.synthetic.main.item_xml_feed.view.*

class XmlFeedAdapter <T, B : ViewDataBinding>(
    private val layoutId: Int,
    items: List<T>,
    val viewModel: BaseViewModel? = null,
    onBind: B.(Int) -> Unit = {},
    val clickHandleInterface: ClickHandleInterface<T>
) : BaseAdapter<T, B>(viewModel = viewModel, items = items, onBind = onBind) {

    var onItemClick: ((detailModel: DetailModel) -> Unit)? = null

    override fun getLayoutId(viewType: Int): Int = layoutId

    override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.itemView.img_favorite_fa.setOnClickListener {
            clickHandleInterface.click(it, items, position)
        }

        holder.itemView.card_xmlItemContainer.setOnClickListener {
            onItemClick?.invoke(getItem(position).let {
                it as DetailModel
            })
        }
    }
}