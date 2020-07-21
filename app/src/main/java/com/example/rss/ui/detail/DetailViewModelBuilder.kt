package com.example.rss.ui.detail

import androidx.lifecycle.ViewModel
import com.example.rss.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(DetailFeedsViewModel::class)
    abstract fun bindDetailFeedViewModel(favoriteViewModel: DetailFeedsViewModel): ViewModel
}