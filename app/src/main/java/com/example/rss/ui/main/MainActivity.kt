package com.example.rss.ui.main

import com.example.rss.base.BaseActivity
import com.example.rss.databinding.ActivityMainBinding
import com.example.rss.R
import com.example.rss.util.extension.toast
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
                    toast("home")
                    true
                }
                R.id.favorite -> {
                    toast("favorites")
                    true
                }
                else -> false
            }

        }
    }

}