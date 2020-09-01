package com.example.padc_thepodcast_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.padc_thepodcast_tutorial_tyno.delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.views.viewholders.YourShowsRecyclerViewHolder

class YourShowsRecyclerAdapter(private var delegate: ItemDelegate) :
    RecyclerView.Adapter<YourShowsRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourShowsRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_download_your_show_item, parent, false)
        return YourShowsRecyclerViewHolder(view, delegate)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: YourShowsRecyclerViewHolder, position: Int) {

    }
}