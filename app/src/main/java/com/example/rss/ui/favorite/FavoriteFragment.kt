package com.example.rss.ui.favorite

import androidx.lifecycle.Observer
import com.example.rss.R
import com.example.rss.base.BaseFragment
import com.example.rss.base.ViewModelScope
import com.example.rss.databinding.FragmentFavoriteBinding
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.util.extension.toast

class FavoriteFragment : BaseFragment<FavoriteViewModel, FragmentFavoriteBinding>() {

    companion object {
        fun newInstance() =
            FavoriteFragment()
    }

    override val viewModel: FavoriteViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int = R.layout.fragment_favorite

    override fun onViewInitialized() {
        binding.apply {
            vm = viewModel
            adapter = FavoriteAdapter(emptyList(), viewModel)

        }
        binding.adapter?.onFavorite = {
            when(it){
                is ArticleModel -> {
                    viewModel.unFavoriteJsonFeed(it)
                }
                is DetailModel -> {
                    viewModel.unFavoriteXmlFeed(it)
                }
            }
        }
        binding.adapter?.onItemClick = {
            when(it){
                is ArticleModel -> {
                    toast(it.description)
                }
                is DetailModel -> {
                    toast(it.description.orEmpty())
                }
            }
        }
        bindObservables()
    }

    private fun bindObservables() {
        viewModel.combineLiveData().observe(this, Observer {
            binding.adapter?.swapItems(it)

        })
    }
}