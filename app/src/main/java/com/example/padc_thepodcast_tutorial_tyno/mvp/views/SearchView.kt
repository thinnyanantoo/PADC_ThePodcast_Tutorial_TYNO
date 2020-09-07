package com.example.padc_thepodcast_tutorial_tyno.mvp.views

import com.example.padc_thepodcast_tutorial_tyno.data.vos.GenereVO

interface SearchView : BaseView {

    fun showGenereList (genereList : List<GenereVO>)

    fun showGenere(genereVO: GenereVO)

    fun displayEmptyView()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun hideEmptyView()
}