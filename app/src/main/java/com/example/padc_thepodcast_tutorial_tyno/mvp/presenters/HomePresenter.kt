package com.example.padc_thepodcast_tutorial_tyno.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.padc_thepodcast_tutorial_tyno.delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.BasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.HomeView
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.EmptyViewPod
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.PlaybackHomeViewPod

interface HomePresenter: BasePresenter<HomeView>,ItemDelegate, EmptyViewPod.Delegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner)

    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
}