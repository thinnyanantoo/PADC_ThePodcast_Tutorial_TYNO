package com.example.padc_thepodcast_tutorial_tyno.views.viewholders

import android.view.View
import com.example.padc_thepodcast_tutorial_tyno.delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.HomeView

class CategorySearchRecyclerViewHolder(itemView: View) : BaseViewHolder<HomeView>(itemView) {

    init {
        itemView.setOnClickListener {
            // delegate.onTapItem()
        }
    }

    override fun bindData(data: HomeView) {

    }
}