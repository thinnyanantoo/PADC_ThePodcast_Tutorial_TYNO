package com.example.padc_thepodcast_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_thepodcast_tutorial_tyno.adapters.UpNextHomeRecyclerAdapter
import kotlinx.android.synthetic.main.rv_item_up_next_home.view.*
import kotlinx.android.synthetic.main.up_next_home_recycler_view_pod.*
import kotlinx.android.synthetic.main.up_next_home_recycler_view_pod.view.*


class UpNextHomeViewPod @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, delfStyleAttr: Int = 0
) : LinearLayout(context, attr, delfStyleAttr) {

    fun bindAdapter(upNextHomeRecyclerAdapter: UpNextHomeRecyclerAdapter) {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvUpNextHome.layoutManager = linearLayoutManager
        rvUpNextHome.adapter = upNextHomeRecyclerAdapter
       // straightProgressUpNext.progressSet = 70
    }

}