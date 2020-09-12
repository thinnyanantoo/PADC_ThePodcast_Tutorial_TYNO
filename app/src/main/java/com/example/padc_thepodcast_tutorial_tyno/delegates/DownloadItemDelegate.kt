package com.example.padc_thepodcast_tutorial_tyno.delegates

import com.example.padc_thepodcast_tutorial_tyno.data.vos.DownloadVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO

interface DownloadItemDelegate {
    fun onTapDownloadItem(id : String)
   // fun onTapDownload(downloadVO: DownloadVO)
}