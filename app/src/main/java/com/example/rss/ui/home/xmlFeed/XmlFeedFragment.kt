package com.example.rss.ui.home.xmlFeed

import androidx.lifecycle.Observer
import com.example.rss.R
import com.example.rss.base.BaseFragment
import com.example.rss.base.ViewModelScope
import com.example.rss.base.adapter.SingleLayoutAdapter
import com.example.rss.databinding.FragmentXmlFeedBinding
import com.example.rss.databinding.ItemXmlFeedBinding
import com.example.rss.domain.model.xmlFeed.DetailModel

class XmlFeedFragment : BaseFragment<XmlFeedViewModel, FragmentXmlFeedBinding>() {

    override val viewModel: XmlFeedViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int = R.layout.fragment_xml_feed

    override fun onViewInitialized() {
        binding.apply {
            vm = viewModel
            adapter = SingleLayoutAdapter<DetailModel, ItemXmlFeedBinding>(
                R.layout.item_xml_feed,
                emptyList(),
                vm)
        }
        bindObservables()
    }

    private fun bindObservables(){
        viewModel.xmlFeedLiveData.observe(this, Observer {
            binding.adapter?.swapItems(it)
        })
    }
}