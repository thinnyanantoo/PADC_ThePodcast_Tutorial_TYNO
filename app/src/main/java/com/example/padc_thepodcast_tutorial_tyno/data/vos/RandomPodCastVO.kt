package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.PodCastTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "randomPodCast")
@TypeConverters(PodCastTypeConverter::class)
data class RandomPodCastVO(
    @PrimaryKey
    @SerializedName("id") var id: String,
    @SerializedName("title") var title: String ? = "",
    @SerializedName("description") var description: String? = "",
    @SerializedName("pub_date_ms") var pubDateMs: Long? = 1L,
    @SerializedName("audio") var audio: String? = "",
    @SerializedName("audio_length_sec") var audioLengthSec: Int,
    @SerializedName("listennotes_url") var listenNoteUrl: String,
    @SerializedName("image") var image: String? = "",
    @SerializedName("thumbnail") var thumbNail: String,
    @SerializedName("maybe_audio_invalid") var maybeAudioInvalid: Boolean,
    @SerializedName("listennotes_edit_url") var listennoteEditUrl: String,
    @SerializedName("explicit_content") var explicitContent: Boolean,
    @SerializedName("link") var link: String,
    @SerializedName("podcast")var podCast : PodCastVO)



