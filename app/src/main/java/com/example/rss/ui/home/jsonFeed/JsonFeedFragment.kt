package com.example.rss.ui.home.jsonFeed

import androidx.lifecycle.Observer
import com.example.rss.R
import com.example.rss.base.BaseFragment
import com.example.rss.base.ViewModelScope
import com.example.rss.base.adapter.SingleLayoutAdapter
import com.example.rss.databinding.FragmentJsonFeedBinding
import com.example.rss.databinding.ItemJsonFeedBinding
import com.example.rss.domain.model.jsonFeed.ArticleModel


class JsonFeedFragment : BaseFragment<JsonFeedViewModel, FragmentJsonFeedBinding>() {

    override val viewModel: JsonFeedViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int = R.layout.fragment_json_feed

    override fun onViewInitialized() {
        binding.apply {
            vm = viewModel
            adapter = SingleLayoutAdapter<ArticleModel, ItemJsonFeedBinding>(
                R.layout.item_json_feed,
                emptyList(),
                vm)
        }
        bindObservables()
    }

    private fun bindObservables(){
        viewModel.jsonFeedLiveData.observe(this, Observer {
            binding.adapter?.swapItems(it)
        })
    }

}