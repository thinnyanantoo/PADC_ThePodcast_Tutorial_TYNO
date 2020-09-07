package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padc_thepodcast_tutorial_tyno.delegates.DownloadItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DownloadView

interface DownloadPresenter : BasePresenter <DownloadView>,DownloadItemDelegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner)

}