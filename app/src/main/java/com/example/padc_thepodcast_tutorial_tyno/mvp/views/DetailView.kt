package com.example.padc_thepodcast_tutorial_tyno.mvp.views

import com.example.padc_thepodcast_tutorial_tyno.data.vos.*
import com.example.padc_thepodcast_tutorial_tyno.persistence.daos.EpisodeDetailDao

interface DetailView : BaseView  {
    fun showDeail(episodeDetailVO: LatestEpisodeVO)
   // fun showDetailDownload(downloadVO: DownloadVO)
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
}