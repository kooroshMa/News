package com.example.rss.ui.detail

import com.example.rss.base.BaseActivity
import com.example.rss.databinding.ActivityDetailFeedsBinding
import com.example.rss.R

class DetailFeedsActivity : BaseActivity<DetailFeedsViewModel, ActivityDetailFeedsBinding>() {
    override val viewModel: DetailFeedsViewModel by getLazyViewModel()
    override val layoutId: Int = R.layout.activity_detail_feeds

    override fun onViewInitialized() {
        binding.vm = viewModel
    }
}