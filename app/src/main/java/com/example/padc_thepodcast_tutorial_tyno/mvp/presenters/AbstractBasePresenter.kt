package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters

import com.example.padc_thepodcast_tutorial_tyno.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>,BaseView {
    var mView : T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}