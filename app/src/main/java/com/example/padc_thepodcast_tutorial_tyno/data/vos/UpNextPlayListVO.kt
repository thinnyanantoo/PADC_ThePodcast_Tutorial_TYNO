package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.PodCastTypeConverter
import com.google.gson.annotations.SerializedName
@Entity(tableName = "upNextTable")
data class UpNextPlayListVO(
    @PrimaryKey
    @SerializedName("id") var id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("pub_date_ms") var pubDateMS: Long,
    @SerializedName("audio") var audio: String,
    @SerializedName("audio_length_sec") var audioLengthSec: Int,
    @SerializedName("listennotes_url") var listenNotesURl: String,
    @SerializedName("image") var image: String,
    @SerializedName("thumbnail") var thumbNail: String,
    @SerializedName("maybe_audio_invalid") var audioInvalid: Boolean,
    @SerializedName("listennotes_edit_url") var listenNotesEditUrl: String,
    @SerializedName("explicit_content") var explicitContent: Boolean,
    @SerializedName("link") var link: String,
    @SerializedName("podcast")var podCastVO: PodCastVO
)

