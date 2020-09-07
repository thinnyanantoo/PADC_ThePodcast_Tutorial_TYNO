package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.ExtraVoTypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.GenreTypeConverter
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.LookingForTypeConverters
import com.google.gson.annotations.SerializedName
data class PodCastDetailVO(
    @SerializedName("country") var country: String,
    @SerializedName("description") var description: String,
    @SerializedName("earliest_pub_date_ms") var earliest_pub_date_ms: Long,
    @SerializedName("email") var email: String,
    @SerializedName("explicit_content") var explicit_content: Boolean,

    @SerializedName("extra") var extra: ExtraVO,

    @SerializedName("genre_ids") var genre_ids: List<Int>,

    @PrimaryKey
    @SerializedName("id") var pid: String,
    @SerializedName("image") var image: String,
    @SerializedName("is_claimed") var is_claimed: Boolean,
    @SerializedName("itunes_id") var itunes_id: Int,
    @SerializedName("language") var language: String,
    @SerializedName("latest_pub_date_ms") var latest_pub_date_ms: Long,
    @SerializedName("listennotes_url") var listennotes_url: String,

    @SerializedName("looking_for") var looking_for: LookingForVO,
    @SerializedName("publisher") var publisher: String,
    @SerializedName("rss") var rss: String,
    @SerializedName("thumbnail") var thumbnail: String,
    @SerializedName("title") var title: String,
    @SerializedName("total_episodes") var total_episodes: Int,
    @SerializedName("type") var type: String,
    @SerializedName("website") var website: String

)