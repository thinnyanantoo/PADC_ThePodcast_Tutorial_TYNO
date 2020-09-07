package com.example.padc_thepodcast_tutorial_tyno.mvp.presenter

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO
import com.example.padc_thepodcast_tutorial_tyno.delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.BasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.HomeView
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.EmptyViewPod

interface HomePresenter: BasePresenter<HomeView>,ItemDelegate, EmptyViewPod.Delegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner)

    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)

    fun ondownloadItem(context : Context, episodePlaylistVO: EpisodePlaylistVO)
    //fun saveDownlaod(upNextPlayListVO: UpNextPlayListVO)

}