package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genereTable")
data class GenereVO (
    @PrimaryKey
    @SerializedName("id")var id: Int,
    @SerializedName("name")var name : String,
    @SerializedName("parent_id")var parentId : Int

)