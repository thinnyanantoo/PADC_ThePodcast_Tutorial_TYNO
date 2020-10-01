package com.example.padc_thepodcast_tutorial_tyno.delegates

import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.LatestEpisodeVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastDetailVO
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.PlaybackHomeViewPod

interface ItemDelegate  {
   // fun onTapUpNextItem(episodePlaylistVO: PodCastDetailVO)
   fun onTapItem(podCastId : String)

    fun onTapDownloadIcon(episodePlaylistVO: LatestEpisodeVO)
}