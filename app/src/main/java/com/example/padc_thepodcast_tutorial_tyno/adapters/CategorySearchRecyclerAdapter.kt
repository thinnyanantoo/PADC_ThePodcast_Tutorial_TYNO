package com.example.padc_thepodcast_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.TouchDelegate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.padc_thepodcast_tutorial_tyno.Delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.views.viewholders.CategorySearchRecyclerViewHolder

class CategorySearchRecyclerAdapter(private var delegate: ItemDelegate) : RecyclerView.Adapter<CategorySearchRecyclerViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategorySearchRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_search_category_item,parent,false)
        return CategorySearchRecyclerViewHolder(view,delegate)
    }

    override fun getItemCount(): Int {
 return 10
    }

    override fun onBindViewHolder(holder: CategorySearchRecyclerViewHolder, position: Int) {

    }
}