package com.example.padc_thepodcast_tutorial_tyno.network.responses

import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO
import com.google.gson.annotations.SerializedName

data class EpisodePlayListResponse(
    @SerializedName("type") val type: String,
    @SerializedName("items") val itemsResponse: List<EpisodePlaylistVO> = emptyList(),
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("thumbnail") val thumNail: String,
    @SerializedName("visibility") val visibility: String,
    @SerializedName("total") val total: Int,
    @SerializedName("listennotes_url") val listenNoteUrl: String,
    @SerializedName("last_timestamp_ms") val lastTimeStampMS: String
)