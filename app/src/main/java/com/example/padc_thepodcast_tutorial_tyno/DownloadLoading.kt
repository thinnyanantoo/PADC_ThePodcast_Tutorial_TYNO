package com.example.padc_thepodcast_tutorial_tyno

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import kotlin.coroutines.coroutineContext

fun DownloadLoading(context: Context, episodePlaylistVO: EpisodePlaylistVO){
//    val downloadId : Long
        val uri = Uri.parse(episodePlaylistVO.data!!.audio)
        val request = DownloadManager.Request(uri).apply{
        setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
        setTitle(episodePlaylistVO.data.title)
        setDescription(episodePlaylistVO.data.description)
        setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${episodePlaylistVO.data.title.trim().substring(0,8)}.mp3")
    }
    val downloadManager = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
       downloadManager.enqueue(request)
}