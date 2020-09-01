package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import android.provider.MediaStore.Audio.Playlists.Members.PLAYLIST_ID
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenter.HomePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.HomeView
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.PlaybackHomeViewPod

class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    var mPodCastModel: PodCastModel = PodCastModelImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        requestAllRandomPodCast(lifecycleOwner)
        requestAllUpNextPodCastList(lifecycleOwner)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestAllRandomPodCast(lifecycleOwner)
        requestAllUpNextPodCastList(lifecycleOwner)

    }

    override fun onTapItem() {
        mView?.navigateToDetailActivity()
    }

    override fun onTapPlay() {
        mView?.actionOnPlayTap()
    }

    override fun onTapPause() {
        mView?.actionOnPauseTap()
    }

    override fun displayEmptyView() {
        TODO("Not yet implemented")
    }

    override fun enableSwipeRefresh() {
        TODO("Not yet implemented")
    }

    override fun disableSwipeRefresh() {
        TODO("Not yet implemented")
    }

    private fun requestAllRandomPodCast(lifecycleOwner: LifecycleOwner) {
        mView?.enableSwipeRefresh()
        mPodCastModel.getAllRandomPodCast(onError = {
            mView?.disableSwipeRefresh()
            mView?.displayEmptyView()
        }).observe(lifecycleOwner, Observer {
            mView?.disableSwipeRefresh()
//            if(it.isEmpty())
//                mView?.displayEmptyView()
//            else
            mView?.displayRandomPodCastList(it)

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

}