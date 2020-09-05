package com.example.padc_thepodcast_tutorial_tyno.data.models.Impls

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.padc_thepodcast_tutorial_tyno.BuildConfig
import com.example.padc_thepodcast_tutorial_tyno.data.models.BaseModel
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodeDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.GenereVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO
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

    override fun getEpisdeDetail(id: String, onError: (String) -> Unit): LiveData<EpisodeDetailVO> {
        return mTheDB.EpisodeDetailDao().getEpisodeById(id)
    }

    @SuppressLint("CheckResult")
    override fun getEpisodeDetailByIdFromApiAndSaveToDatabase(
        id: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi
            .getDetail(id, API_VALUE)
            .map {
                it.toList() ?: listOf()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.EpisodeDetailDao().insertAllDetail(it)
            }, {
                Log.e("error", it.localizedMessage)
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
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
            .getGenere(1, API_VALUE)
            .map {
                Log.e("KEy","Reach to response")
                it.generes?.toList() ?: listOf()
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
