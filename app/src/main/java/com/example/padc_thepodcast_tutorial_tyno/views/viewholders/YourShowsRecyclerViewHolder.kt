package com.example.padc_thepodcast_tutorial_tyno.views.viewholders

import android.view.View
import com.example.padc_thepodcast_tutorial_tyno.delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.HomeView

class YourShowsRecyclerViewHolder(itemView: View, delegate: ItemDelegate) :
    BaseViewHolder<HomeView>(itemView) {
    override fun bindData(data: HomeView) {

    }

    init {
        itemView.setOnClickListener {
            delegate.onTapItem()
        }
    }
}