package com.example.padc_thepodcast_tutorial_tyno.network

import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO
import com.example.padc_thepodcast_tutorial_tyno.network.responses.EpisodePlayListResponse
import com.example.padc_thepodcast_tutorial_tyno.utils.API_KEY
import com.example.padc_thepodcast_tutorial_tyno.utils.GET_RANDOM_PODCAST
import io.reactivex.Observable
import retrofit2.http.*

interface PodCastApi {

    @GET(GET_RANDOM_PODCAST)
    fun getRandomPodCast(@Header(API_KEY) apiKey: String): Observable<RandomPodCastVO>

    @GET("playlists/{id}")
    fun getUpNextPlayList(
        @Path("id") id: String,
        @Query("type") type: String,
        @Query("last_timestamp_ms") lastTimeStamp: String,
        @Query("sort") sort: String,
        @Header(API_KEY) apiKey: String
    ): Observable<EpisodePlayListResponse>
}