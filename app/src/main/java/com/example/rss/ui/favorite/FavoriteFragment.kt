package com.example.rss.ui.favorite

import android.util.Log
import androidx.lifecycle.Observer
import com.example.rss.R
import com.example.rss.base.BaseFragment
import com.example.rss.base.ViewModelScope
import com.example.rss.databinding.FragmentFavoriteBinding
import com.example.rss.domain.model.FeedsModel

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
            adapter = FavoriteAdapter(emptyList(),viewModel)
        }

        bindObservables()
    }

    private fun bindObservables() {
        val list = mutableListOf<FeedsModel>()
        viewModel.getAllFavoritesLiveData.observe(this, Observer {
            list.addAll(it)
            binding.adapter?.swapItems(list)
        })
    }
}