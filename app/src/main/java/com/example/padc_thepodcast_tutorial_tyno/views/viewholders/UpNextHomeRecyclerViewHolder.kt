package com.example.padc_thepodcast_tutorial_tyno.views.viewholders

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.LatestEpisodeVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO
import com.example.padc_thepodcast_tutorial_tyno.delegates.ItemDelegate
import kotlinx.android.synthetic.main.play_back_view_pod.view.*
import kotlinx.android.synthetic.main.rv_download_your_show_item.view.*
import kotlinx.android.synthetic.main.rv_item_up_next_home.view.*

class UpNextHomeRecyclerViewHolder(itemView: View, delegate: ItemDelegate) :
    BaseViewHolder<LatestEpisodeVO>(itemView) {
    override fun bindData(data: LatestEpisodeVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.upNextImage)

        itemView.upNextTitle.text = data.title
    }

    init {
        itemView.setOnClickListener {
            mData?.let{
     //  delegate.onTapUpNextItem(it)
               delegate.onTapItem(it.id.toString())
        }
        }

        itemView.ivDownloadIcon.setOnClickListener {
            mData?.let {
                Log.e("Key","tap on downloadIcon")
                delegate.onTapDownloadIcon(it)
            }
        }
    }
}