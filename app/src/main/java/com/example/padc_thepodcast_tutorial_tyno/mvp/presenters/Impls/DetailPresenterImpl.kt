package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.BasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.DetailPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.BaseView
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {
    private  var mPodCastModle : PodCastModel = PodCastModelImpl
    override fun onUiReady(id: String,lifecycleOwner: LifecycleOwner) {
        getEpisode(id,lifecycleOwner)

    }

    override fun onSwipeRefresh(id: String,lifecycleOwner: LifecycleOwner) {
        getEpisode(id,lifecycleOwner)
    }

    fun getEpisode(id : String,lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
      mPodCastModle.getEpisdeDetail(
          id,
          onError = {
          mView?.disableSwipeRefresh()
          mView?.displayEmptyView()
      })
          .observe(lifecycleOwner, Observer {
              it?.let{
              mView?.showDeail(it)
          }
          })
      }

    override fun displayEmptyView() {
        TODO("Not yet implemented")
    }

    override fun enableSwipeRefresh() {

    }

    override fun disableSwipeRefresh() {
        TODO("Not yet implemented")
    }

}