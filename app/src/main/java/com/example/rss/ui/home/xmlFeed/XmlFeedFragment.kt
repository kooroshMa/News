package com.example.rss.ui.home.xmlFeed

import com.example.rss.R
import com.example.rss.base.BaseFragment
import com.example.rss.base.ViewModelScope
import com.example.rss.databinding.FragmentXmlFeedBinding

class XmlFeedFragment : BaseFragment<XmlFeedViewModel, FragmentXmlFeedBinding>() {
    override val viewModel: XmlFeedViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int = R.layout.fragment_xml_feed

    override fun onViewInitialized() {
        binding.vm = viewModel
    }
}