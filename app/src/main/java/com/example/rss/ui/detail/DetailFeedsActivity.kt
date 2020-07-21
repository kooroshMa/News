package com.example.rss.ui.detail

import android.util.Log
import androidx.lifecycle.Observer
import com.example.rss.R
import com.example.rss.base.BaseActivity
import com.example.rss.databinding.ActivityDetailFeedsBinding
import com.example.rss.domain.model.FeedsModel
import com.example.rss.domain.model.FeedsType
import kotlinx.android.synthetic.main.activity_detail_feeds.*

class DetailFeedsActivity : BaseActivity<DetailFeedsViewModel, ActivityDetailFeedsBinding>() {

    lateinit var id: String
    lateinit var type: FeedsType
    override val viewModel: DetailFeedsViewModel by getLazyViewModel()
    override val layoutId: Int = R.layout.activity_detail_feeds

    override fun onViewInitialized() {
        binding.vm = viewModel

        initWebView()
        getBundles()
        handleStarClickEvent()
        viewModel.findFromDb(id,type)
        bindObservables()
    }

    private fun initWebView() {
        my_web_view.webViewClient = MyWebViewClient()
    }

    private fun getBundles() {
        id = intent.getStringExtra("id").orEmpty()
        type = intent?.getSerializableExtra("enumType") as FeedsType
    }

    private fun handleStarClickEvent() {
        img_favorite.setOnClickListener {
            viewModel.findFromDb(id, type)
            viewModel.favoriteOrUnFavorite(type)
        }
    }

    fun bindObservables(){
        viewModel.feedsLiveData.observe(this, Observer {
            my_web_view.loadUrl(it.link)
        })
    }
}