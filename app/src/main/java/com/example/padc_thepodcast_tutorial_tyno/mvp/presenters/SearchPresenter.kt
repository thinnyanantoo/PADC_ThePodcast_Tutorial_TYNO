package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.SearchView
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.EmptyViewPod

interface SearchPresenter : BasePresenter<SearchView>, EmptyViewPod.Delegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner)

    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)

}