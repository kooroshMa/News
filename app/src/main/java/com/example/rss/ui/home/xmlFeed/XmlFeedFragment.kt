package com.example.rss.ui.home.xmlFeed

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.rss.R
import com.example.rss.base.BaseFragment
import com.example.rss.base.ViewModelScope
import com.example.rss.base.adapter.ClickHandleInterface
import com.example.rss.databinding.FragmentXmlFeedBinding
import com.example.rss.databinding.ItemXmlFeedBinding
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.ui.detail.DetailFeedsActivity
import com.example.rss.util.extension.toast

class XmlFeedFragment : BaseFragment<XmlFeedViewModel, FragmentXmlFeedBinding>() {

    override val viewModel: XmlFeedViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int = R.layout.fragment_xml_feed

    override fun onViewInitialized() {
        binding.apply {
            vm = viewModel
            adapter = XmlFeedAdapter<DetailModel, ItemXmlFeedBinding>(
                R.layout.item_xml_feed,
                emptyList(),
                vm,
                onBind = {
                    position = it
                },
                clickHandleInterface = object : ClickHandleInterface<DetailModel> {
                    override fun click(view: View, items: List<DetailModel>, position: Int) {
                        if (items[position].isFavorite) viewModel.unFavoriteXmlFeed(items[position])
                        else viewModel.favoriteXmlFeed(items[position])
                    }
                })
        }

        binding.adapter?.onItemClick = {
            val bundle = Bundle()
            bundle.putParcelable("model" , (it as DetailModel))
            viewModel.activityAction{ activity ->
                viewModel.navigator.startActivity(activity,
                    DetailFeedsActivity::class.java,
                    Bundle()
                )}
        }
        bindObservables()
    }

    private fun bindObservables() {
        viewModel.xmlFeedLiveData.observe(this, Observer {
            binding.adapter?.swapItems(it)
        })
    }
}