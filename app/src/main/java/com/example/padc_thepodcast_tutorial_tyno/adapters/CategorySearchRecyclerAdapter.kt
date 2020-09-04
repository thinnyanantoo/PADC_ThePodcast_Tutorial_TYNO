package com.example.padc_thepodcast_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.padc_thepodcast_tutorial_tyno.delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.data.vos.GenereVO
import com.example.padc_thepodcast_tutorial_tyno.views.viewholders.CategorySearchRecyclerViewHolder

class CategorySearchRecyclerAdapter() : BaseRecyclerAdapter<CategorySearchRecyclerViewHolder, GenereVO>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategorySearchRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_search_category_item, parent, false)
        return CategorySearchRecyclerViewHolder(view)
    }

}