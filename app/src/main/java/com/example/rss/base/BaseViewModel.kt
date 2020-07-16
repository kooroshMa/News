package com.example.rss.base

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.example.rss.util.connectivity.BaseConnectionManager
import com.example.rss.util.livedata.ActivityActionLiveData
import com.example.rss.util.livedata.FragmentActionLiveData
import com.example.rss.util.livedata.SingleEventLiveData
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel (private val connectionManager: BaseConnectionManager)
    : ViewModel(),
    LifecycleObserver {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val activityAction = ActivityActionLiveData()
    val fragmentAction = FragmentActionLiveData()
    val showLoading = SingleEventLiveData<Boolean>()
    val toastMessage = SingleEventLiveData<String>()
    val dismissDialog = SingleEventLiveData<String>()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun checkConnection() {
        if (connectionManager.isVPNConnected() == true)
            Log.d("VPN Status", "Connected")
        else
            Log.d("VPN Status", "Nothing")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
    }

    fun showLoading() {
        showLoading.value = true
    }

    fun hideLoading() {
        showLoading.value = false
    }

    fun showToastMessage(message: String?) {
        toastMessage.value = message
    }
}