package com.example.padc_thepodcast_tutorial_tyno.data.models.Impls

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.padc_thepodcast_tutorial_tyno.DownloadLoading
import com.example.padc_thepodcast_tutorial_tyno.data.models.BaseModel
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.data.vos.*
import com.example.padc_thepodcast_tutorial_tyno.network.FireBaseApi
import com.example.padc_thepodcast_tutorial_tyno.network.RealtimeDatabaseFirebaeApiImpl


object PodCastModelImpl : PodCastModel, BaseModel() {
    override var mFireBaseApi: FireBaseApi = RealtimeDatabaseFirebaeApiImpl

    @SuppressLint("CheckResult")
    override fun getAllRandomPodCastFromFireBaseAndSaveToDatabase(
        onSuccess: (PodCastDetailVO) -> Unit,
        onError: (String) -> Unit
    ) {
        mFireBaseApi.getRandomPodCast(onSuccess = {
            mTheDB.RandomPodCastDao().insertAllRandomPodCasts(it)
        }, onFailure = {
            onError
        })
    }
    override fun getAllRandom(onError: (String) -> Unit): LiveData<PodCastDetailVO> {
        return mTheDB.RandomPodCastDao().getAllRandomPodCast()
    }

    override fun getUpNextListfromFirebaseToDatabase(
        onSuccess: (List<LatestEpisodeVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mFireBaseApi.getUpNext(onSuccess ={
            mTheDB.EpisodeDetailDao().insertAllDetail(it)
        },onFailure =  {
            onError
        })
    }

    override fun getUpNextById(id: String): LiveData<LatestEpisodeVO> {
        return mTheDB.EpisodeDetailDao().getEpisodeById(id)
    }

    override fun getAllUpnextList(onError: (String) -> Unit): LiveData<List<LatestEpisodeVO>> {
        return mTheDB.EpisodeDetailDao().getEpisodes()
    }


    override fun getEpisodeDetailByIdFromApiAndSaveToDatabase(
        id : String,onSuccess: (PodCastDetailVO) -> Unit,
        onError: (String) -> Unit
    ) {
//        mFireBaseApi.getEpisodeDetail(onSuccess={
////            mTheDB.EpisodeDetailDao().insertDetail(it)
////        }, onFailure = {
////            onError
////        })
        mFireBaseApi.getEpisodeDetail(id,onSuccess,onError)
    }

//    override fun getDownloadById(id: String): LiveData<DownloadVO> {
//        return mTheDB.downloadDao().getdownloadById(id)
//    }


    override fun getGenere(onError: (String) -> Unit): LiveData<List<GenereVO>> {
        return mTheDB.GenereDao().getAllGenere()
    }

    override fun getGenereFromFireBaseAndSaveToDatabase(
        onSuccess: (List<GenereVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mFireBaseApi.getGenreList(onSuccess={
            mTheDB.GenereDao().insertAllGenere(it)
        },onFailure = {
            onError
        })
    }

    override fun startdownladPlaylist(context: Context, episodePlaylistVO: LatestEpisodeVO) {
        DownloadLoading(context,episodePlaylistVO)
    }

    override fun getAllDownload(onError: (String) -> Unit): LiveData<List<DownloadVO>> {
          return mTheDB.downloadDao().getAllDownloadedItem()
    }

    override fun getDownloadItme(
        downloadVO: DownloadVO,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
              mTheDB.downloadDao().inserttoDownload(downloadVO)
    }

    override fun getDownloadById(id: String): LiveData<DownloadVO> {
        return mTheDB.downloadDao().getdownloadById(id)
    }

    override fun getDownloadDetail(id: String): LiveData<DownloadVO> {
        return mTheDB.downloadDao().getdownloadById(id)
    }
//
//
//    override fun getEpisdeDetail(id: String): LiveData<LatestEpisodeVO> {
//        return mTheDB.EpisodeDetailDao().getEpisodeById(id)
//    }



}
