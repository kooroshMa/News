package com.example.rss.ui.home.jsonFeed

import android.view.View
import androidx.lifecycle.Observer
import com.example.rss.R
import com.example.rss.base.BaseFragment
import com.example.rss.base.ViewModelScope
import com.example.rss.base.adapter.ClickHandleInterface
import com.example.rss.databinding.FragmentJsonFeedBinding
import com.example.rss.databinding.ItemJsonFeedBinding
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.util.extension.toast


class JsonFeedFragment : BaseFragment<JsonFeedViewModel, FragmentJsonFeedBinding>() {

    override val viewModel: JsonFeedViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int = R.layout.fragment_json_feed

    override fun onViewInitialized() {
        binding.apply {
            vm = viewModel
            adapter = JsonFeedAdapter<ArticleModel, ItemJsonFeedBinding>(
                R.layout.item_json_feed,
                emptyList(),
                vm,
                onBind = {
                    position = it
                },
                clickHandleInterface = object : ClickHandleInterface<ArticleModel> {
                    override fun click(view: View, items: List<ArticleModel>, position: Int) {
                        if (items[position].isFavorite) viewModel.unFavoriteJsonFeed(items[position])
                        else viewModel.favoriteJsonFeed(items[position])
                    }
                })
        }
        bindObservables()
    }

    private fun bindObservables() {
        viewModel.jsonFeedLiveData.observe(this, Observer {
            binding.adapter?.swapItems(it)
        })
    }

}