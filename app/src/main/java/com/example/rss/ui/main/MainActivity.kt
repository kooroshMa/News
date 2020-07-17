package com.example.rss.ui.main

import com.example.rss.base.BaseActivity
import com.example.rss.databinding.ActivityMainBinding
import com.example.rss.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by getLazyViewModel()
    override val layoutId: Int = R.layout.activity_main

    override fun onViewInitialized() {
        binding.apply {
            vm = viewModel
        }
        bottomNav()
    }

    private fun bottomNav() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    viewModel.activityAction{activityAction ->
                        viewModel.navigator.openHomeFragment(activityAction)}
                    true
                }
                R.id.favorite -> {
                    viewModel.activityAction{activityAction ->
                        viewModel.navigator.openFavoriteFragment(activityAction)}
                    true
                }
                else -> false
            }

        }
    }

}