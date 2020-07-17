package com.example.rss.ui.main

import com.example.rss.base.BaseActivity
import com.example.rss.databinding.ActivityMainBinding
import com.example.rss.R

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by getLazyViewModel()
    override val layoutId: Int = R.layout.activity_main

    override fun onViewInitialized() {
        binding.apply {
            vm = viewModel
        }
    }

}