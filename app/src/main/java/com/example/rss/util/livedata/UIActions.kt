package com.example.rss.util.livedata

import androidx.fragment.app.FragmentActivity

typealias ActivityAction = (FragmentActivity) -> Unit

class ActivityActionLiveData : SingleEventLiveData<ActivityAction>() {

    operator fun invoke(action: ActivityAction) {
        this.value = action
    }

}

typealias FragmentAction = (androidx.fragment.app.Fragment) -> Unit

class FragmentActionLiveData : SingleEventLiveData<FragmentAction>() {

    operator fun invoke(action: FragmentAction) {
        this.value = action
    }
}