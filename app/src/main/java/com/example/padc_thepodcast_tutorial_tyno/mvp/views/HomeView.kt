package com.example.padc_thepodcast_tutorial_tyno.mvp.views

import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO

interface HomeView : BaseView{
    fun navigateToDetailActivity(podCastId : String)
    fun actionOnPlayTap()
    fun actionOnPauseTap()
    fun displayRandomPodCastList(podCastList : RandomPodCastVO)
    fun displayUpNextPlayList(upNextList : List<EpisodePlaylistVO>)
    fun displayEmptyView()
    fun hideEmptyView()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
}