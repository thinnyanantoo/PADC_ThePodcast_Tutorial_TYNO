package com.example.padc_thepodcast_tutorial_tyno.data.models

import androidx.lifecycle.LiveData
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO
import java.util.*

interface PodCastModel {
    fun getAllRandomPodCast(onError: (String) -> Unit): LiveData<RandomPodCastVO>

    fun getAllRandomPodCastFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    )

    fun getAllUpNextList(onError: (String) -> Unit): LiveData<List<EpisodePlaylistVO>>

    fun getAllUpNextListFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)
}