package com.example.padc_thepodcast_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.data.vos.DownloadVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO
import com.example.padc_thepodcast_tutorial_tyno.delegates.DownloadItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.views.viewholders.BaseViewHolder
import com.example.padc_thepodcast_tutorial_tyno.views.viewholders.YourShowsRecyclerViewHolder

class YourShowsRecyclerAdapter(private var delegate: DownloadItemDelegate) :
    BaseRecyclerAdapter<YourShowsRecyclerViewHolder, DownloadVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourShowsRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_download_your_show_item, parent, false)
        return YourShowsRecyclerViewHolder(view,delegate)
    }
}