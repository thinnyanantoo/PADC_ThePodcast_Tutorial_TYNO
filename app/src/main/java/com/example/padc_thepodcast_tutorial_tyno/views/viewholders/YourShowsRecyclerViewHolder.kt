package com.example.padc_thepodcast_tutorial_tyno.views.viewholders

import android.text.Html
import android.view.View
import com.bumptech.glide.Glide
import com.example.padc_thepodcast_tutorial_tyno.data.vos.DownloadVO
import com.example.padc_thepodcast_tutorial_tyno.delegates.DownloadItemDelegate
import kotlinx.android.synthetic.main.rv_download_your_show_item.view.*

class YourShowsRecyclerViewHolder(itemView: View,private var delegate: DownloadItemDelegate) :
    BaseViewHolder<DownloadVO>(itemView) {

    override fun bindData(data: DownloadVO) {
        mData = data
        itemView.ivTitle.text = data.title
        itemView.ivTitleDescritpion.text = Html.fromHtml(data.description)
        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivDownload)
    }
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapDownloadItem(it.downloadId)
               // delegate.onTapDownload(it)
            }
        }
    }
}