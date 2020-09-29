package com.example.padc_thepodcast_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_thepodcast_tutorial_tyno.adapters.UpNextHomeRecyclerAdapter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.LatestEpisodeVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO
import kotlinx.android.synthetic.main.up_next_home_recycler_view_pod.view.*


class UpNextHomeViewPod @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, delfStyleAttr: Int = 0
) : LinearLayout(context, attr, delfStyleAttr) {

    fun bindAdapter(
        upNextHomeRecyclerAdapter: UpNextHomeRecyclerAdapter,
        upNextList: MutableList<LatestEpisodeVO>
    ) {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvUpNextHome.layoutManager = linearLayoutManager
        rvUpNextHome.adapter = upNextHomeRecyclerAdapter
        upNextHomeRecyclerAdapter.setData(upNextList)
        // straightProgressUpNext.progressSet = 70
    }
}