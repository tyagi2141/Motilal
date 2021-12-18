package com.example.motilal.data.repo


import android.app.Application
import com.example.motilal.data.db.AppDatabase
import com.example.motilal.data.network.Routes
import com.example.motilal.model.DashboardResponse
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


class AppDataRepository(
    private var app: Application,
    private var apiService: Routes,
    private var localDatabase: AppDatabase
) : DataRepository {
    override fun getData(): Single<List<DashboardResponse>> {

        return apiService.getData().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
    }

    override fun insertAllDashboard(dashboardResponse: List<DashboardResponse>): Completable {
        return localDatabase.dashboardDao().insertAll(dashboardResponse)
    }

    override fun getAllDashBoard(): Observable<List<DashboardResponse>> {
        return localDatabase.dashboardDao().getAll()
    }

}