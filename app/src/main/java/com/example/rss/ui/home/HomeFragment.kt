package com.example.rss.ui.home

import com.example.rss.R
import com.example.rss.base.BaseFragment
import com.example.rss.base.ViewModelScope
import com.example.rss.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    companion object {
        fun newInstance() =
            HomeFragment()
    }

    override val viewModel: HomeViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int = R.layout.fragment_home

    override fun onViewInitialized() {
        binding.vm = viewModel

        configTabLayoutAndViewPager()
    }

    private fun configTabLayoutAndViewPager(){
        val fragmentAdapter = HomePagerAdapter(childFragmentManager)
        view_pager.adapter = fragmentAdapter
        tabLayout_feeds.setupWithViewPager(view_pager)
    }

}