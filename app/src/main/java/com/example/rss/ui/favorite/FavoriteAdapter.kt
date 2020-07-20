package com.example.rss.ui.favorite

import androidx.databinding.ViewDataBinding
import com.example.rss.R
import com.example.rss.base.adapter.BaseAdapter
import com.example.rss.base.adapter.BaseViewHolder
import com.example.rss.databinding.ItemJsonFeedBinding
import com.example.rss.databinding.ItemXmlFeedBinding
import com.example.rss.domain.model.FeedsModel
import com.example.rss.domain.model.FeedsType
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.model.xmlFeed.DetailModel
import kotlinx.android.synthetic.main.item_json_feed.view.*
import kotlinx.android.synthetic.main.item_xml_feed.view.*

class FavoriteAdapter(
    list: List<FeedsModel>,
    private val viewModel: FavoriteViewModel?
) : BaseAdapter<FeedsModel, ViewDataBinding>(viewModel = viewModel, items = list) {

    var onFavoriteClicked: ((feedsModel: FeedsModel) -> Unit)? = null

    companion object {
        private const val JSON_VIEW_TYPE = 1
        private const val XML_VIEW_TYPE = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ArticleModel -> JSON_VIEW_TYPE
            is DetailModel -> XML_VIEW_TYPE
            else -> throw Exception()
        }
    }

    override fun getLayoutId(viewType: Int): Int {
        return when (viewType) {
            XML_VIEW_TYPE -> R.layout.item_xml_feed
            JSON_VIEW_TYPE -> R.layout.item_json_feed
            else -> -1
        }
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<FeedsModel, ViewDataBinding>,
        position: Int
    ) {
        super.onBindViewHolder(holder, position)

        when (holder.binding) {
            is ItemJsonFeedBinding -> {
                getItem(position).let {modelItem ->
                    holder.itemView.img_favorite_en.setOnClickListener{
                        onFavoriteClicked?.invoke(modelItem)
                    }
                }
            }

            is ItemXmlFeedBinding -> {
                getItem(position).let {modelItem ->
                    holder.itemView.img_favorite_fa.setOnClickListener{
                        onFavoriteClicked?.invoke(modelItem)

                    }
                }
            }
        }
    }

}