package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DetailView
import com.example.padc_thepodcast_tutorial_tyno.player.MediaPlayer
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.PlaybackHomeViewPod

interface DetailPresenter : BasePresenter<DetailView>{
    fun onUiReady(id : String,lifecycleOwner: LifecycleOwner)
    fun getPlayer(): MediaPlayer

    fun play(url: String)

    fun releasePlayer()


}