package com.example.padc_thepodcast_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.padc_thepodcast_tutorial_tyno.delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.LatestEpisodeVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO
import com.example.padc_thepodcast_tutorial_tyno.views.viewholders.UpNextHomeRecyclerViewHolder

class UpNextHomeRecyclerAdapter(private var delegate: ItemDelegate) :
    BaseRecyclerAdapter<UpNextHomeRecyclerViewHolder, LatestEpisodeVO>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UpNextHomeRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item_up_next_home, parent, false)
        return UpNextHomeRecyclerViewHolder(view, delegate)
    }

}