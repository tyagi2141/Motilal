package com.example.motilal.data.works

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.motilal.data.network.Routes
import com.example.motilal.data.repo.DataRepository
import javax.inject.Inject
import javax.inject.Provider

class SyncWorker(
    context: Context, workerParams: WorkerParameters,
    private val apiService: Routes,
    private val localDatabase: DataRepository
) : Worker(context, workerParams) {

    companion object {
        const val TAG = "SyncWorker"
    }

    override fun doWork(): Result {
        Log.e(TAG, "Yes ......")

        val s = apiService.getData()
            .map {
                it.let {
                    localDatabase.insertAllDashboard(it.result ?: emptyList()).blockingAwait()
                }
                it
            }.subscribe({
                Log.d("SyncWorker", "ResultFromServer-success:$it")

            }, {
                Log.d("$it", "ResultFromServer-error")

            })

        return Result.success()
    }


    class Factory @Inject constructor(
        private val userRepository: Provider<Routes>,// <-- Add your providers parameters
        private val localDataBase: Provider<DataRepository> // <-- Add your providers parameters
    ) : IWorkerFactory<SyncWorker> {
        override fun create(appContext: Context, params: WorkerParameters): SyncWorker {
            return SyncWorker(appContext, params, userRepository.get(), localDataBase.get())
        }
    }

}