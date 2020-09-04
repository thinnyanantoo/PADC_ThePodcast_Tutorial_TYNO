package com.example.padc_thepodcast_tutorial_tyno.data.models

import androidx.lifecycle.LiveData
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodeDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.GenereVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO
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

    fun getEpisdeDetail(id: String,onError: (String) -> Unit) : LiveData<EpisodeDetailVO>

    fun getEpisodeDetailByIdFromApiAndSaveToDatabase(id: String, onSuccess: () -> Unit,onError: (String) -> Unit)

    fun getGenere(onError: (String) -> Unit) : LiveData<List<GenereVO>>

    fun getGenereFromApiAndSaveToDatabase(onSuccess: () -> Unit,onError: (String) -> Unit)
}