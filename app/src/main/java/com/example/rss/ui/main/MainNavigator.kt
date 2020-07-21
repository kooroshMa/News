package com.example.rss.ui.main

import androidx.fragment.app.FragmentActivity
import com.example.rss.R
import com.example.rss.base.BaseNavigator
import com.example.rss.ui.favorite.FavoriteFragment
import com.example.rss.ui.home.HomeFragment
import javax.inject.Inject

class MainNavigator @Inject constructor(): BaseNavigator {

    fun openHomeFragment(activity: FragmentActivity){
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout_fragmentContainer, HomeFragment.newInstance())
            .commitAllowingStateLoss()
    }

    fun openFavoriteFragment(activity: FragmentActivity){
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout_fragmentContainer, FavoriteFragment.newInstance())
            .commitAllowingStateLoss()
    }
}