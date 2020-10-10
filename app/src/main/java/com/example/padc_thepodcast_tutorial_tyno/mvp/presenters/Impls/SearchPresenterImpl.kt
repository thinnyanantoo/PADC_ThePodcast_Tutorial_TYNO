package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.SearchPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.SearchView

class SearchPresenterImpl : SearchPresenter, AbstractBasePresenter<SearchView>() {
    private var mPodCatModle : PodCastModel = PodCastModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        getGenereList(lifecycleOwner)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        getGenereList(lifecycleOwner)

    }


    fun getGenereList(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        mPodCatModle.getGenere(onError = {
            mView?.disableSwipeRefresh()
            mView?.displayEmptyView()
        } ).observe(lifecycleOwner, Observer {
            mView?.showGenereList(it)
            mView?.showGenere(it.get(0))
        })
    }

    fun loadAllGenereFromApi(){
      //  mPodCatModle.getGenereFromApiAndSaveToDatabase({},{})
    }

}

