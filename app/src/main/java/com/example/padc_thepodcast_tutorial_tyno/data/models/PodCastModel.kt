package com.example.padc_thepodcast_tutorial_tyno.data.models

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.padc_thepodcast_tutorial_tyno.data.vos.*
import com.example.padc_thepodcast_tutorial_tyno.network.FireBaseApi

interface PodCastModel {
    var mFireBaseApi: FireBaseApi

    fun getRandomPodCast(onError: (String) -> Unit): LiveData<LatestEpisodeVO>

    fun getUpNextListfromFirebaseToDatabase(
        onSuccess: (List<LatestEpisodeVO>) -> Unit,
        onError: (String) -> Unit
    )

    fun getUpNextById(id: String): LiveData<LatestEpisodeVO>
    fun getAllUpnextList(onError: (String) -> Unit): LiveData<List<LatestEpisodeVO>>


    fun getEpisodeDetailByIdFromApiAndSaveToDatabase(
        id: String,
        onSuccess: (PodCastDetailVO) -> Unit,
        onError: (String) -> Unit
    )

    fun getGenere(onError: (String) -> Unit): LiveData<List<GenereVO>>
    fun getGenereFromFireBaseAndSaveToDatabase(
        onSuccess: (List<GenereVO>) -> Unit,
        onError: (String) -> Unit
    )

    fun startdownladPlaylist(context: Context, episodePlaylistVO: LatestEpisodeVO)
    fun getAllDownload(onError: (String) -> Unit): LiveData<List<DownloadVO>>
    fun getDownloadDetail(id: String): LiveData<DownloadVO>
    fun getDownloadItme(downloadVO: DownloadVO, onSuccess: () -> Unit, onError: (String) -> Unit)
    fun getDownloadById(id: String): LiveData<DownloadVO>

}