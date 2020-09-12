package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.data.vos.DownloadVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenter.HomePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.HomeView
import com.example.padc_thepodcast_tutorial_tyno.player.MediaPlayerImpl

class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>(){

    var mPodCastModel: PodCastModel = PodCastModelImpl
    private val player = MediaPlayerImpl()
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        requestAllRandomPodCast(lifecycleOwner)
        requestAllUpNextPodCastList(lifecycleOwner)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestAllRandomPodCast(lifecycleOwner)
        requestAllUpNextPodCastList(lifecycleOwner)
    }

    override fun ondownloadItem(context: Context, episodePlaylistVO: EpisodePlaylistVO) {
        mPodCastModel.startdownladPlaylist(context, episodePlaylistVO)
    }

    override fun getPlayer() = player
    override fun play(url: String) {
        player.play(url)
    }

    override fun releasePlayer() = player.releasePlayer()


//    override fun onTapUpNextItem(episodePlaylistVO: EpisodePlaylistVO) {
//        mView?.navigateToDetailActivity(episodePlaylistVO.data.id)
//
//    }

    override fun onTapDownloadIcon(episodePlaylistVO: EpisodePlaylistVO) {
        val downloadVO = episodePlaylistVO.data!!.title?.let {
            DownloadVO(
                episodePlaylistVO.data!!.id,
                it, episodePlaylistVO.data!!.description!!,episodePlaylistVO.data.thumbNail!!, episodePlaylistVO.data.title!!.trim().substring(0,8)
            )
        }
        mPodCastModel?.getDownloadItme(downloadVO!!,onSuccess = {},onError = {})
        mView?.selectedDownloadItem(episodePlaylistVO)
    }

    override fun onTapItem(podCastId : String) {
        mView?.navigateToDetailActivity(podCastId)
    }

    override fun onTapTryAgain() {
        loadAllPodCastFromApi()
    }


    private fun requestAllRandomPodCast(lifecycleOwner: LifecycleOwner) {
        val RandomPodCast = MutableLiveData<RandomPodCastVO>()
        mView?.enableSwipeRefresh()
        mPodCastModel.getAllRandomPodCast(onError = {
//            mView?.disableSwipeRefresh()
//            mView?.displayEmptyView()
              RandomPodCast.postValue(null)
        }).observe(lifecycleOwner, Observer {
            RandomPodCast.postValue(it)
            mView?.disableSwipeRefresh()
            if(it!=null){
                mView?.displayRandomPodCastList(it)
                mView?.displayEmptyView()
            }
            else
            {
                mView?.disableSwipeRefresh()
            }
        })
    }

    private fun requestAllUpNextPodCastList(lifecycleOwner: LifecycleOwner) {
        mView?.enableSwipeRefresh()
        mPodCastModel.getAllUpNextList(
            onError = {
                mView?.disableSwipeRefresh()
                mView?.displayEmptyView()
            }).observe(lifecycleOwner, Observer {
            mView?.disableSwipeRefresh()
            if (it.isEmpty())
                mView?.displayEmptyView()
            else
                mView?.displayUpNextPlayList(it)
        })
    }

    private fun loadAllPodCastFromApi() {
        mPodCastModel.getAllUpNextListFromApiAndSaveToDatabase(onSuccess = {

        }, onError = {

        })
    }
}