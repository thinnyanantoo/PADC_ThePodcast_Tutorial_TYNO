package com.example.padc_thepodcast_tutorial_tyno.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetPodCastWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorkers(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()

        mPodCastModel.getAllRandomPodCastFromApiAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

        mPodCastModel.getAllUpNextListFromApiAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

        return result
    }
}