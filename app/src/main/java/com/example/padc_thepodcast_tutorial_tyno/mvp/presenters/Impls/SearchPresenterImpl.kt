package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.SearchPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.SearchView

class SearchPresenterImpl : SearchPresenter, AbstractBasePresenter<SearchView>() {
    override fun displayEmptyView() {

    }

    override fun enableSwipeRefresh() {

    }

    override fun disableSwipeRefresh() {

    }

}