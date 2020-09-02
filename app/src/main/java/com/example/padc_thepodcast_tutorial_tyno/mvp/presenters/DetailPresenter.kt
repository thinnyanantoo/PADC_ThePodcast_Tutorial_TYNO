package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DetailView

interface DetailPresenter : BasePresenter<DetailView> {
    fun onUiReady(id : String,lifecycleOwner: LifecycleOwner)

    fun onSwipeRefresh(id: String,lifecycleOwner: LifecycleOwner)
}