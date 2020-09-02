package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.ExtraVoTypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.GenreTypeConverter
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.LookingForTypeConverters
import com.google.gson.annotations.SerializedName

@TypeConverters(
    ExtraVoTypeConverters::class,
    GenreTypeConverter::class,
    LookingForTypeConverters::class
)
data class PodCastDetailVO(
    @SerializedName("id") var id: String,
    @SerializedName("title") var title: String,
    @SerializedName("publisher") var publisher: String,
    @SerializedName("image") var image: String,
    @SerializedName("thumbnail") var thumbNail: String,
    @SerializedName("listennotes_url") var listenNotesUrl: String,
    @SerializedName("total_episodes") var totalEpisodes: Int,
    @SerializedName("explicit_content") var explicitContent: Boolean,
    @SerializedName("description") var description: String,
    @SerializedName("itunes_id") var itunesId: Int,
    @SerializedName("rss") var rss: String,
    @SerializedName("latest_pub_date_ms") var latestPubDateMs: Int,
    @SerializedName("earliest_pub_date_ms") var earliestPubdateMs: Int,
    @SerializedName("language") var language: String,
    @SerializedName("country") var country: String,
    @SerializedName("website") var website: String,
    @SerializedName("extra") var extra: ExtraVO,
    @SerializedName("is_claimed") var isClaimed: Boolean,
    @SerializedName("email") var email: String,
    @SerializedName("type") var type: String,
    @SerializedName("looking_for") var lookingFor: LookingForVO,
    @SerializedName("genre_ids") var genreIds: List<Int>

)