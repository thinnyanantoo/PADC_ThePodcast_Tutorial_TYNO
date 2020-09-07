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
data class EpisodeDetailVO(
   @SerializedName("audio")var audio: String,
@SerializedName("audio_length_sec")var audio_length_sec: String,
@SerializedName("description")var description: String,
@SerializedName("explicit_content")var explicit_content: Boolean,

@PrimaryKey
@SerializedName("id")var id: String,
@SerializedName("image")var image: String,
@SerializedName("link")var link: String,
@SerializedName("listennotes_edit_url")var listennotes_edit_url: String,
@SerializedName("listennotes_url")var listennotes_url: String,
@SerializedName("maybe_audio_invarid")var maybe_audio_invarid: Boolean,

@SerializedName("podcast")var podcastVO: PodCastDetailVO,
@SerializedName("pub_date_ms")var pub_date_ms: Long,
@SerializedName("thumbnail")var thumbnail: String,
@SerializedName("title")var title: String
)