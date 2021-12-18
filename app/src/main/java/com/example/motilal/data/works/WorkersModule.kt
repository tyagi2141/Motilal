package com.example.motilal.data.works

import androidx.work.ListenableWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
interface WorkersModule {

    @Binds
    @IntoMap
    @WorkerKey(SyncWorker::class)
    fun bindMyWorker(worker: SyncWorker.Factory): IWorkerFactory<out ListenableWorker>

}