package com.example.rss.ui.favorite

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.rss.R
import com.example.rss.base.BaseFragment
import com.example.rss.base.ViewModelScope
import com.example.rss.databinding.FragmentFavoriteBinding
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.ui.detail.DetailFeedsActivity
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
                    val bundle = Bundle()
                    bundle.putParcelable("model" , (it))
                    viewModel.activityAction{ activity ->
                        viewModel.navigator.startActivity(activity,
                        DetailFeedsActivity::class.java,
                        Bundle()
                    )}
                }
                is DetailModel -> {
                    val bundle = Bundle()
                    bundle.putParcelable("model" , (it))
                    viewModel.activityAction{ activity ->
                        viewModel.navigator.startActivity(activity,
                            DetailFeedsActivity::class.java,
                            Bundle()
                        )}
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