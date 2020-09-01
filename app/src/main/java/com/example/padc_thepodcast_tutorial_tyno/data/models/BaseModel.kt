package com.example.padc_thepodcast_tutorial_tyno.data.models

import android.content.Context
import com.example.padc_thepodcast_tutorial_tyno.network.PodCastApi
import com.example.padc_thepodcast_tutorial_tyno.persistence.db.PodCastDB
import com.example.padc_thepodcast_tutorial_tyno.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected lateinit var mApi: PodCastApi
    protected lateinit var mTheDB: PodCastDB

    init {
        val mOkHttpBuilder = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpBuilder)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mApi = retrofit.create(PodCastApi::class.java)
    }

    fun initDatabase(context: Context) {
        mTheDB = PodCastDB.getDBInstance(context)
    }
}