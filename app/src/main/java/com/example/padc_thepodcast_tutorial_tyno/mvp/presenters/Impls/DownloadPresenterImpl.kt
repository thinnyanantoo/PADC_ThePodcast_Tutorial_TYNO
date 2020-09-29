package com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.data.vos.DownloadVO
import com.example.padc_thepodcast_tutorial_tyno.delegates.DownloadItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.AbstractBasePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.DownloadPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DownloadView

class DownloadPresenterImpl : DownloadPresenter, AbstractBasePresenter<DownloadView>(),
    DownloadItemDelegate {
    private val mPodCastModel = PodCastModelImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
          mPodCastModel.getAllDownload(onError = {})
              .observe(lifecycleOwner, Observer {
                  it?.let { mView?.showDownloadedItemList(it)}
              })
    }

    override fun onTapDownload(downloadVO: DownloadVO) {
        mView?.navigateToDetailFromDownload(downloadVO.downloadId)
    }

    override fun onTapDownloadItem(id  : String) {
        mView?.navigateToDetailFromDownload(id)
    }



}