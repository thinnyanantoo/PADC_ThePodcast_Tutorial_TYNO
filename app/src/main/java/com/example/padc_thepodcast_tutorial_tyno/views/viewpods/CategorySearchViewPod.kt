package com.example.padc_thepodcast_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_thepodcast_tutorial_tyno.adapters.CategorySearchRecyclerAdapter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.GenereVO
import kotlinx.android.synthetic.main.categories_recyclerview_view_pod.*
import kotlinx.android.synthetic.main.categories_recyclerview_view_pod.view.*
import kotlinx.android.synthetic.main.up_next_home_recycler_view_pod.view.*

class CategorySearchViewPod @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, delfStyleAttr : Int = 0
): RelativeLayout(context,attr,delfStyleAttr){

    fun bindAdapter(
        categorySearchRecyclerAdapter: CategorySearchRecyclerAdapter,
        categoryList: MutableList<GenereVO>
        ) {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvCategorySearch.layoutManager = linearLayoutManager
        rvCategorySearch.adapter = categorySearchRecyclerAdapter
            categorySearchRecyclerAdapter.setData(categoryList)
            // straightProgressUpNext.progressSet = 70
    }



}