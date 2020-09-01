package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import androidx.lifecycle.LifecycleOwner
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.DownloadPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DownloadView

class DownloadPresenterImpl : DownloadPresenter, AbstractBasePresenter<DownloadView>(){
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
    }

    override fun onTapItem() {
        mView?.navigateToDetailActivity()
    }

    override fun onTapPlay() {
        TODO("Not yet implemented")
    }

    override fun onTapPause() {
        TODO("Not yet implemented")
    }

    override fun displayEmptyView() {
    }

    override fun enableSwipeRefresh() {
    }

    override fun disableSwipeRefresh() {

    }
}