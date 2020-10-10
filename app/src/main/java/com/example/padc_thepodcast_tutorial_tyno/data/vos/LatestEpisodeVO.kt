package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.PodCastTypeConverter
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
@Entity(tableName = "detailTable")
@TypeConverters(PodCastTypeConverter::class)
data class LatestEpisodeVO(
    @SerializedName("audio") var audio: String = "",
    @SerializedName("audio_length_sec") var audioLengthSec: Int = 0,
    @SerializedName("description") var description: String = "",
    @SerializedName("explicit_content") var explicitContent: Boolean = false,

    @PrimaryKey
    @SerializedName("id") var id: String = " ",
    @SerializedName("image") var image: String = "",
    @SerializedName("link") var link: String = "",
    @SerializedName("listennotes_edit_url") var listennoteEditUrl: String = "",
    @SerializedName("listennotes_url") var listenNoteUrl: String = "",
    @SerializedName("maybe_audio_invalid") var maybeAudioInvalid: Boolean = false,
    @SerializedName("podcast")var podCast : PodCastVO = PodCastVO(),

    @SerializedName("pub_date_ms") var pubDateMs: Long = 1L,
    @SerializedName("thumbnail") var thumbNail: String = "",
    @SerializedName("title") var title: String  = "")

fun MutableMap<String,Any>?.convertToLatestEpisodeVO() : LatestEpisodeVO{
    val latestEpisodeVO = LatestEpisodeVO()
    latestEpisodeVO.id = this?.get("id")as String
    latestEpisodeVO.image = this["image"]as String
    latestEpisodeVO.title = this["title"]as String
    latestEpisodeVO.description = this["description"]as String
    latestEpisodeVO.audio = this["audio"]as String
    latestEpisodeVO.audioLengthSec= (this["audio_length_sec"]as Long).toInt()


    return latestEpisodeVO

}



