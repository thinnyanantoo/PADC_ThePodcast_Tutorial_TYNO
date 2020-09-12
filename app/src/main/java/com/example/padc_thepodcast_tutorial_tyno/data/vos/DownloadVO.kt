package com.example.padc_thepodcast_tutorial_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "downloadTable")
class DownloadVO(
    @PrimaryKey
       val downloadId : String,
    val title: String,
    val description: String? = null,
    var pubDateMS: Long? = null,
    var audio: String? = null,
    var audioLengthSec: String? = null,
    var listenNotesURl: String? = null,
    var image: String? = null,
    var thumbNail: String? = null,
    var audioInvalid: Boolean? = null,
    var listenNotesEditUrl: String? = null,
    var link: String? = null
//    val downloadId : String,
//    val downloadPodCastTitle : String,
//    val downloadPodCastDescription : String,
//    val downloadPodCastUrl : String,
//    val downloadAudioPath : String
    // val downloadImage : String


)