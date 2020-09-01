package com.example.padc_thepodcast_tutorial_tyno

import android.app.Application
import androidx.work.*
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.workers.GetPodCastWorker
import java.util.concurrent.TimeUnit

class PodCastApp : Application() {

    override fun onCreate() {
        super.onCreate()
        PodCastModelImpl.initDatabase(applicationContext)

        getPodCastOneTime()
        getPodCastPeriodically()
        getMovieWhileInDozeMode()
    }

    private fun getPodCastOneTime() {
        val getEventsWorkRequest = OneTimeWorkRequest.Builder(GetPodCastWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

    private fun getPodCastPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val getEventsPeroidicallyWorkRequest = PeriodicWorkRequest
            .Builder(GetPodCastWorker::class.java, 30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsPeroidicallyWorkRequest)
    }

    private fun getMovieWhileInDozeMode() {
        val constraints = Constraints
            .Builder()
            .setRequiresDeviceIdle(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val getEventsWhileInDozeModeWorkRequest = PeriodicWorkRequest
            .Builder(GetPodCastWorker::class.java, 1, TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWhileInDozeModeWorkRequest)
    }

}