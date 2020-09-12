package com.example.padc_thepodcast_tutorial_tyno.data.vos

import com.google.gson.annotations.SerializedName

data class PodCastVO(
    @SerializedName("id") var id: String,
    @SerializedName("title") var title: String? = null,
    @SerializedName("publisher") var publisher: String? =  null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("thumbnail") var thumbNail: String? = null,
    @SerializedName("listennotes_url") var listenNotesUrl: String? = null
)
