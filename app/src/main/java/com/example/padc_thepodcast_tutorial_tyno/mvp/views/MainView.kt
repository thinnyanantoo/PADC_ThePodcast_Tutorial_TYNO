package com.example.padc_thepodcast_tutorial_tyno.mvp.views

interface MainView : BaseView {
    fun displayFragment()
    fun displayEmptyView()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
}