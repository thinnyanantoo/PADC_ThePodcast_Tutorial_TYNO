package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.BasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.DetailPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.BaseView
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DetailView
import com.example.padc_thepodcast_tutorial_tyno.player.MediaPlayer
import com.example.padc_thepodcast_tutorial_tyno.player.MediaPlayerImpl

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {
    private  var mPodCastModle : PodCastModel = PodCastModelImpl
    private val mediaPlayer = MediaPlayerImpl()
    override fun onUiReady(id: String,lifecycleOwner: LifecycleOwner) {
       // getEpisode(id,lifecycleOwner)

        mPodCastModle.getEpisodeDetailByIdFromApiAndSaveToDatabase(
            id,{},{})

        mPodCastModle.getEpisdeDetail(id).observe(
            lifecycleOwner, Observer {
                it?.let {
                    mView?.showDeail(it)
                }
            }
        )
    }

    override fun getPlayer() = mediaPlayer

    override fun play(url: String) {
         mediaPlayer.play(url)
    }

    override fun releasePlayer() {
        mediaPlayer.releasePlayer()
    }



//    fun getEpisode(id : String,lifecycleOwner: LifecycleOwner){
//        mView?.enableSwipeRefresh()
//      mPodCastModle.getEpisdeDetail(
//          id,
//          onError = {
//          mView?.disableSwipeRefresh()
//      })
//          .observe(lifecycleOwner, Observer {
//              it?.let{
//              mView?.showDeail(it)
//          }
//          })
//      }

//    fun getDetailDownload(id : String, lifecycleOwner: LifecycleOwner)
//    {
//        mView?.enableSwipeRefresh()
//        mPodCastModle.getDownloadDetail(
//            id
//        ).observe(lifecycleOwner, Observer {
//            it?.let {
//                mView?.showDetailDownload(it)
//            }
//        })
//    }
}