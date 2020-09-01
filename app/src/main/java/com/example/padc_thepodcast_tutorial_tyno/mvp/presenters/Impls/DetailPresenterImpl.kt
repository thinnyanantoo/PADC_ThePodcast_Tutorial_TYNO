package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import androidx.lifecycle.LifecycleOwner
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.DetailPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {

    }

    override fun displayEmptyView() {

    }

    override fun enableSwipeRefresh() {

    }

    override fun disableSwipeRefresh() {

    }
}