package com.example.padc_thepodcast_tutorial_tyno.network

import com.example.padc_thepodcast_tutorial_tyno.data.vos.*

interface FireBaseApi {
    fun getRandomPodCast(onSuccess : (podcast : List<PodCastDetailVO>)-> Unit, onFailure: (String) -> Unit)
    fun getUpNext(onSuccess : (podcast : List<LatestEpisodeVO>)-> Unit, onFailure: (String) -> Unit)
    fun getGenreList(onSuccess: (genre : List<GenereVO>) -> Unit, onFailure: (String) -> Unit)
    fun getEpisodeDetail(id: String,onSuccess: (episode : PodCastDetailVO) -> Unit, onFailure: (String) -> Unit)
}