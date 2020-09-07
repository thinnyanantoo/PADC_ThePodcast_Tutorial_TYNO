package com.example.padc_thepodcast_tutorial_tyno.delegates

import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.PlaybackHomeViewPod

interface ItemDelegate : PlaybackHomeViewPod.Delegate {
    fun onTapUpNextItem(episodePlaylistVO: EpisodePlaylistVO)

    fun onTapDownloadIcon(episodePlaylistVO: EpisodePlaylistVO)
}