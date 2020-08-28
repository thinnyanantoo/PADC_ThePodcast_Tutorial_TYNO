package com.example.padc_thepodcast_tutorial_tyno.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.padc_thepodcast_tutorial_tyno.Delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.BasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.MainView

interface MainPresenter: BasePresenter<MainView>,ItemDelegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner)

    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
}