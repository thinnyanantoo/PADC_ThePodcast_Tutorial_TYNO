package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.MainPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>(){
    override fun onAttachWithFragment() {

    }

    override fun displayEmptyView() {
    }

    override fun enableSwipeRefresh() {
    }

    override fun disableSwipeRefresh() {
    }
}