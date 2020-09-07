package com.example.padc_thepodcast_tutorial_tyno.views.viewholders

import android.view.View
import com.example.padc_thepodcast_tutorial_tyno.data.vos.GenereVO
import com.example.padc_thepodcast_tutorial_tyno.delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.HomeView
import kotlinx.android.synthetic.main.fragment_search.view.*
import kotlinx.android.synthetic.main.rv_search_category_item.view.*

class CategorySearchRecyclerViewHolder(itemView: View) : BaseViewHolder<GenereVO>(itemView) {

    override fun bindData(data: GenereVO) {
        itemView.tvItemName.text = data.name
    }
    init {
        itemView.setOnClickListener {
            // delegate.onTapItem()
        }
    }


}