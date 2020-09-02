package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.ExtraVoTypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.GenreTypeConverter
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.LookingForTypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.PodCastDetialVOTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "detailTable")
@TypeConverters(
    PodCastDetialVOTypeConverter::class
)
data class EpisodeDetailVO(
    @PrimaryKey
    @SerializedName("id") var id: String,
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String,
    @SerializedName("pub_data_ms") var pubDateMS: Int,
    @SerializedName("audio") var audio: String,
    @SerializedName("audio_length_sec") var audioLengthSec: Int,
    @SerializedName("listennotes_url") var listenNotesUrl: String,
    @SerializedName("image") var image: String,
    @SerializedName("thumbnail") var thumbNail: String,
    @SerializedName("maybe_audio_invalid") var maybeAudioInvalid: Boolean,
    @SerializedName("listennotes_edit_url") var listenNotesEditUrl: String,
    @SerializedName("explicit_content") var explicitContent: Boolean,
    @SerializedName("link") var link: String,
    @SerializedName("podcast") var podCast: List<PodCastDetailVO> = emptyList()
)