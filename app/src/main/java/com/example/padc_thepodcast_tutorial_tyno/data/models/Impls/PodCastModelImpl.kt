package com.example.padc_thepodcast_tutorial_tyno.data.models.Impls

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.padc_thepodcast_tutorial_tyno.BuildConfig
import com.example.padc_thepodcast_tutorial_tyno.DownloadLoading
import com.example.padc_thepodcast_tutorial_tyno.data.models.BaseModel
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.data.vos.*
import com.example.padc_thepodcast_tutorial_tyno.network.responses.GetgenereResponse
import com.example.padc_thepodcast_tutorial_tyno.utils.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.http.PATCH

object PodCastModelImpl : PodCastModel, BaseModel() {
    override fun getAllRandomPodCast(onError: (String) -> Unit): LiveData<RandomPodCastVO> {
        return mTheDB.RandomPodCastDao().getAllRandomPodCast()
    }

    @SuppressLint("CheckResult")
    override fun getAllRandomPodCastFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi
            .getRandomPodCast(API_VALUE)
            .map {
                it
            }
            .subscribeOn(Schedulers.io())
            .observeOn(
                AndroidSchedulers.mainThread()
            )
            .subscribe({
                mTheDB.RandomPodCastDao().insertAllRandomPodCasts(it)
            }, {
                Log.e("error", it.localizedMessage)
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllUpNextList(onError: (String) -> Unit): LiveData<List<EpisodePlaylistVO>> {
        return mTheDB.UpNextPlayListDao().getAllUpNextPlayList()
    }

    override fun getUpNextById(id: String): LiveData<EpisodePlaylistVO> {
        return mTheDB.UpNextPlayListDao().getUpNextById(id)
    }

    override fun getDownloadById(id: String): LiveData<DownloadVO> {
        return mTheDB.downloadDao().getdownloadById(id)
    }


    override fun getGenere(onError: (String) -> Unit): LiveData<List<GenereVO>> {
        return mTheDB.GenereDao().getAllGenere()
    }

    @SuppressLint("CheckResult")
    override fun getGenereFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi
            .getGenere(API_VALUE, TOP_LEVEL_ONLY)
            .map {
                it.generes.toList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(
                AndroidSchedulers.mainThread()
            )
            .subscribe({
                mTheDB.GenereDao().insertAllGenere(it)
            }, {
                Log.e("error", it.localizedMessage)
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun startdownladPlaylist(
        context: Context,
        episodePlaylistVO: EpisodePlaylistVO
    ) {
        DownloadLoading(context,episodePlaylistVO)
    }

    override fun getAllDownload(onError: (String) -> Unit): LiveData<List<DownloadVO>> {
          return mTheDB.downloadDao().getAllDownloadedItem()
    }

    override fun getDownloadDetail(id: String): LiveData<DownloadVO> {
        return mTheDB.downloadDao().getdownloadById(id)
    }

    override fun getDownloadItme(
        downloadVO: DownloadVO,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mTheDB.downloadDao().inserttoDownload(downloadVO)

    }

    override fun getEpisdeDetail(id: String): LiveData<EpisodeDetailVO> {
        return mTheDB.EpisodeDetailDao().getEpisodeById(id)
    }

    @SuppressLint("CheckResult")
    override fun getEpisodeDetailByIdFromApiAndSaveToDatabase(
        id: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi
            .getDetail("4d3fe717742d4963a85562e9f84d8c79", API_VALUE)
            .map {
                it
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let{ episode ->
                    mTheDB.EpisodeDetailDao().insertDetail(episode)
                }
            }, {
                Log.e("error", it.localizedMessage)
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")
    override fun getAllUpNextListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi
            .getUpNextPlayList(PLAYLIST_ID, TYPE, LAST_TIME_STAMP, SORT, API_VALUE)
            .map {
                it.itemsResponse?.toList() ?: listOf()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(
                AndroidSchedulers.mainThread()
            )
            .subscribe(
                {
                    mTheDB.UpNextPlayListDao().insertAllUpNextPodCast(it)
                },
                {
                    Log.e("error", it.localizedMessage)
                    onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
                })
    }

}
