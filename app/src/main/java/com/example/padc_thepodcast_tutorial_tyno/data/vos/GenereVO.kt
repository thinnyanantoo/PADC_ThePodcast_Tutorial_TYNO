package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.GenreTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genereTable")
data class GenereVO (
    @PrimaryKey
    @SerializedName("id")var id: String,
    @SerializedName("parent_id")var parentId : Int,
    @SerializedName("name")var name : String

)