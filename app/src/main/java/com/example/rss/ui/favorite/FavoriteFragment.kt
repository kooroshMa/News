package com.example.rss.ui.favorite

import androidx.fragment.app.Fragment
import com.example.rss.R
import com.example.rss.base.BaseFragment
import com.example.rss.base.ViewModelScope
import com.example.rss.databinding.FragmentFavoriteBinding

class FavoriteFragment : BaseFragment<FavoriteViewModel, FragmentFavoriteBinding>() {

    override val viewModel: FavoriteViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int = R.layout.fragment_favorite

    override fun onViewInitialized() {
        binding.vm = viewModel
    }

}