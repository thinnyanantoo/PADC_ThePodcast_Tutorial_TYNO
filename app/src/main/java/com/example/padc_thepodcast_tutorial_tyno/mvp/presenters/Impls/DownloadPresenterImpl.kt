package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import androidx.lifecycle.LifecycleOwner
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.DownloadPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DownloadView

class DownloadPresenterImpl : DownloadPresenter, AbstractBasePresenter<DownloadView>(){
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
    }
}