package com.example.padc_thepodcast_tutorial_tyno.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.padc_thepodcast_tutorial_tyno.Delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.MainView

class CategorySearchRecyclerViewHolder(itemView : View,delegate : ItemDelegate): BaseViewHolder<MainView>(itemView) {

    init {
        itemView.setOnClickListener {
            delegate.onTapItem()
        }
    }
    override fun bindData(data: MainView) {

    }
}