package com.example.padc_thepodcast_tutorial_tyno

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import kotlin.coroutines.coroutineContext

fun DownloadLoading(context: Context, episodePlaylistVO: EpisodePlaylistVO) : Long{

    var downloadId = 0L
    var request:  DownloadManager.Request
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N){
    request = DownloadManager.Request(Uri.parse(episodePlaylistVO.data.link))
        .setTitle(episodePlaylistVO.data.title)
        .setDescription("Downloading")
        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        .setRequiresCharging(false)
        .setAllowedOverMetered(true)
        .setAllowedOverRoaming(true)
    }
    else {
        request = DownloadManager.Request(Uri.parse(episodePlaylistVO.data.link))
            .setTitle(episodePlaylistVO.data.title)
            .setDescription("Downloading")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setAllowedOverRoaming(true)
    }
    val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    downloadId = downloadManager.enqueue(request)
    return downloadId
}