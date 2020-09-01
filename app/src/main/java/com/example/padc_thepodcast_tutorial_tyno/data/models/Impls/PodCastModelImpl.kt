package com.example.padc_thepodcast_tutorial_tyno.data.models.Impls

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.padc_thepodcast_tutorial_tyno.data.models.BaseModel
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO
import com.example.padc_thepodcast_tutorial_tyno.utils.*
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
            .map { it }
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