package com.example.padc_thepodcast_tutorial_tyno.mvp.views

import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.LatestEpisodeVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastDetailVO

interface HomeView : BaseView{
    fun navigateToDetailActivity(id : String)
//    fun displayRandomPodCastList(podCastList : LatestEpisodeVO)
    fun displayUpNextPlayList(upNextList: List<LatestEpisodeVO>)
    fun displayEmptyView()
    fun hideEmptyView()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()

    fun selectedDownloadItem(episodePlaylistVO: LatestEpisodeVO)

    fun randomList(randomList : LatestEpisodeVO)
}