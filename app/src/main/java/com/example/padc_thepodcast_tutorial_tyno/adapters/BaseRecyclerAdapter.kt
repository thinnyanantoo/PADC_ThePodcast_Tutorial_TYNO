//package com.example.padc_thepodcast_tutorial_tyno.adapters
//
//import androidx.recyclerview.widget.RecyclerView
//import com.example.padc_thepodcast_tutorial_tyno.views.viewholders.BaseViewHolder
//
//abstract class BaseRecyclerAdapter<T : BaseViewHolder<W>, W> : RecyclerView.Adapter<T>() {
//
//    private var mData : MutableList<W> = arrayListOf()
//
//    override fun getItemCount(): Int {
//        return  mData.size
//    }
//
//    override fun onBindViewHolder(holder: T, position: Int) {
//        holder.bindData(mData[position])
//    }
//
//    fun setNewData(data : MutableList<W>){
//        mData = data
//        notifyDataSetChanged()
//    }
//}