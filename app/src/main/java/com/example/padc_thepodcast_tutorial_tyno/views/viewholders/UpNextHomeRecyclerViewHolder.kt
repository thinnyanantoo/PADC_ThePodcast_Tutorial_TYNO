package com.example.padc_thepodcast_tutorial_tyno.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.padc_thepodcast_tutorial_tyno.Delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.MainView
import kotlinx.android.synthetic.main.rv_item_up_next_home.*

class UpNextHomeRecyclerViewHolder(itemView: View,delegate : ItemDelegate) : BaseViewHolder<MainView>(itemView) {
    override fun bindData(data: MainView) {
    }

    init {
        itemView.setOnClickListener {
            delegate.onTapItem()
        }
    }
}