package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.UpNextPlayListTypeConverters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "podcastUpNextEpisode")
data class EpisodePlaylistVO(
    @PrimaryKey
    @SerializedName("id") var id: Int,
    @SerializedName("type") var type: String,
    @SerializedName("notes") var notes: String,
    @SerializedName("added_at_ms") var addedAtMs: Long,
    @SerializedName("data") val data: UpNextPlayListVO? = null
)



