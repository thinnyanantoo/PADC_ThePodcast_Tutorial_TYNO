package com.example.padc_thepodcast_tutorial_tyno.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel

abstract class BaseWorkers(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    val mPodCastModel: PodCastModel = PodCastModelImpl
}