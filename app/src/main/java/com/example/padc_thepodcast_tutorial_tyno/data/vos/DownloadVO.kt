package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "downloadTable")
class DownloadVO (
    @PrimaryKey
    val downloadId : String,
    val downloadPodCastTitle : String,
    val downloadPodCastDescription : String,
    val downloadPodCastUrl : String,
    val downloadAudioPath : String
  // val downloadImage : String


)