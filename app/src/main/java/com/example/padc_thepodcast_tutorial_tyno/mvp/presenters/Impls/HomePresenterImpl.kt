package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.data.vos.*
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenter.HomePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.HomeView
import com.example.padc_thepodcast_tutorial_tyno.player.MediaPlayerImpl

class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

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

    fun requestAllRandomPodCast(lifecycleOwner: LifecycleOwner){
        mPodCastModel.getAllRandom (
            onError = {
                mView?.disableSwipeRefresh()
                mView?.displayEmptyView()
            }).observe(lifecycleOwner, Observer {
            if(it != null)
            mView?.randomList(it)
        }
        )
    }

    fun requestAllUpNextPodCastList(lifecycleOwner: LifecycleOwner){
        mPodCastModel.getAllUpnextList(
            onError = {
                mView?.disableSwipeRefresh()
                mView?.displayEmptyView()
            }).observe(lifecycleOwner, Observer {
            mView?.displayUpNextPlayList(it)
        }
        )
    }

    override fun ondownloadItem(context: Context, episodePlaylistVO: LatestEpisodeVO) {
        mPodCastModel.startdownladPlaylist(context, episodePlaylistVO)
    }

    override fun saveDownlaod(upNextPlayListVO: UpNextPlayListVO) {
        TODO("Not yet implemented")
    }


    override fun onTapTryAgain() {
        TODO("Not yet implemented")
    }


    override fun getPlayer() = player
    override fun play(url: String) {
        player.play(url)
    }

    override fun releasePlayer() = player.releasePlayer()

    override fun onTapItem(podCastId: String) {
        mView?.navigateToDetailActivity(podCastId)
    }

    override fun onTapDownloadIcon(episodePlaylistVO: LatestEpisodeVO) {
        val downloadVO = episodePlaylistVO.title?.let {
            DownloadVO(
                episodePlaylistVO.id,
                it, episodePlaylistVO.description!!,episodePlaylistVO.pubDateMs,episodePlaylistVO.audio,episodePlaylistVO.audioLengthSec.toString(),episodePlaylistVO.listenNoteUrl,episodePlaylistVO.image,episodePlaylistVO.thumbNail,episodePlaylistVO.maybeAudioInvalid,episodePlaylistVO.listennoteEditUrl, episodePlaylistVO.title.trim().substring(0,8)
            )
        }
        mPodCastModel?.getDownloadItme(downloadVO!!,onSuccess = {},onError = {})
        mView?.selectedDownloadItem(episodePlaylistVO)
    }


}