package com.example.padc_thepodcast_tutorial_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.padc_thepodcast_tutorial_tyno.Delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.views.viewholders.UpNextHomeRecyclerViewHolder

class UpNextHomeRecyclerAdapter(private var delegate : ItemDelegate) : RecyclerView.Adapter<UpNextHomeRecyclerViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UpNextHomeRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_up_next_home,parent,false)
        return UpNextHomeRecyclerViewHolder(view,delegate)
    }

    override fun getItemCount(): Int {
       return 10
    }

    override fun onBindViewHolder(holder: UpNextHomeRecyclerViewHolder, position: Int) {
    }
}