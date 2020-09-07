package com.example.padc_thepodcast_tutorial_tyno.data.models

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.padc_thepodcast_tutorial_tyno.data.vos.*
import com.example.padc_thepodcast_tutorial_tyno.network.responses.GetgenereResponse
import io.reactivex.CompletableOnSubscribe
import io.reactivex.Observable
import java.util.*

interface PodCastModel {
    fun getAllRandomPodCast(onError: (String) -> Unit): LiveData<RandomPodCastVO>

    fun getAllRandomPodCastFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    )

    fun getAllUpNextList(onError: (String) -> Unit): LiveData<List<EpisodePlaylistVO>>

    fun getAllUpNextListFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getUpNextById(id: String): LiveData<EpisodePlaylistVO>

    fun getEpisdeDetail(id: String) : LiveData<EpisodeDetailVO>
    fun getEpisodeDetailByIdFromApiAndSaveToDatabase(id: String, onSuccess: () -> Unit,onError: (String) -> Unit)

    fun getGenere(onError: (String) -> Unit) : LiveData<List<GenereVO>>

    fun getGenereFromApiAndSaveToDatabase(onSuccess: () -> Unit,onError: (String) -> Unit)

    fun startdownladPlaylist(context : Context, episodePlaylistVO: EpisodePlaylistVO)
    fun getAllDownload(onError: (String) -> Unit): LiveData<List<DownloadVO>>
    fun getDownloadDetail(id: String) :LiveData<DownloadVO>
    fun getDownloadItme(downloadVO: DownloadVO, onSuccess: () -> Unit,onError: (String) -> Unit)
    fun getDownloadById(id : String) : LiveData<DownloadVO>

}