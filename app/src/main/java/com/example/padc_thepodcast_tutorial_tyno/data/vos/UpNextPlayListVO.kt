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
    @SerializedName("description") val description: String? = null,
    @SerializedName("pub_date_ms") var pubDateMS: Long? = null,
    @SerializedName("audio") var audio: String ?= null,
    @SerializedName("audio_length_sec") var audioLengthSec: String? = null,
    @SerializedName("listennotes_url") var listenNotesURl: String? = null,
    @SerializedName("image") var image: String ? = null,
    @SerializedName("thumbnail") var thumbNail: String? = null,
    @SerializedName("maybe_audio_invalid") var audioInvalid: Boolean? = null,
    @SerializedName("listennotes_edit_url") var listenNotesEditUrl: String ? = null,
    @SerializedName("explicit_content") var explicitContent: Boolean? = null,
    @SerializedName("link") var link: String? = null,
    @SerializedName("podcast")var podCastVO: PodCastVO ? = null
)

