package com.example.padc_thepodcast_tutorial_tyno.mvp.views

import com.example.padc_thepodcast_tutorial_tyno.data.vos.DownloadVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO

interface DownloadView : BaseView{
    fun navigateToDetailFromDownload(id : String)

    fun showDownloadedItemList(upNextPlayListVO: List<DownloadVO>)
}