package com.example.padc_thepodcast_tutorial_tyno.data.vos

import com.google.gson.annotations.SerializedName

data class PodCastVO(
    @SerializedName("id") var id: String,
    @SerializedName("title") var title: String,
    @SerializedName("publisher") var publisher: String,
    @SerializedName("image") var image: String,
    @SerializedName("thumbnail") var thumbNail: String,
    @SerializedName("listennotes_url") var listenNotesUrl: String
)
