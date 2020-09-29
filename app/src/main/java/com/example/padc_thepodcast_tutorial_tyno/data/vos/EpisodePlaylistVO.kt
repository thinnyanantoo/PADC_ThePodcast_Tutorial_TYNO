package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.UpNextPlayListTypeConverters
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@Keep
@Entity(tableName = "podcastUpNextEpisode")
@IgnoreExtraProperties
class EpisodePlaylistVO(
    @PrimaryKey
    @SerializedName("id") var id: Int = 0,
    @SerializedName("type") var type: String? = "",
    @SerializedName("notes") var notes: String? = "",
    @SerializedName("added_at_ms") var addedAtMs: Long? = 0L,
    @SerializedName("data") val data: UpNextPlayListVO? = null
){

}







