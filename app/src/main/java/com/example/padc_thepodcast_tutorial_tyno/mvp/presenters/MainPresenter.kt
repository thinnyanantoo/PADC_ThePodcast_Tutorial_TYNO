package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters

import com.example.padc_thepodcast_tutorial_tyno.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView> {
    fun onAttachWithFragment()
}