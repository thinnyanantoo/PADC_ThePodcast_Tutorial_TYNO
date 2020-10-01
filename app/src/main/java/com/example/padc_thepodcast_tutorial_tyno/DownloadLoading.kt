package com.example.padc_thepodcast_tutorial_tyno

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.LatestEpisodeVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastDetailVO
import kotlin.coroutines.coroutineContext

fun DownloadLoading(context: Context, episodePlaylistVO: LatestEpisodeVO){
//    val downloadId : Long
        val uri = Uri.parse(episodePlaylistVO.audio)
        val request = DownloadManager.Request(uri).apply{
        setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
        setTitle(episodePlaylistVO.title)
        setDescription(episodePlaylistVO.description)
        setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${episodePlaylistVO.title.trim().substring(0,8)}.mp3")
    }
    val downloadManager = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
       downloadManager.enqueue(request)
}