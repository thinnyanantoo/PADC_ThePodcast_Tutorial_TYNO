package com.example.padc_thepodcast_tutorial_tyno.mvp.views

import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodeDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.persistence.daos.EpisodeDetailDao

interface DetailView : BaseView  {
    fun showDeail(episodeDetailVO: EpisodeDetailVO)
    fun showbMiniPlayBack(episodePlaylistVO: EpisodePlaylistVO)
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
}