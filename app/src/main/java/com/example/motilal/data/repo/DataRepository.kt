package com.example.motilal.data.repo

import com.example.motilal.model.DashboardResponse
import com.example.motilal.model.Result
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single


interface DataRepository {

    fun getData(): Single<DashboardResponse>
    fun insertAllDashboard(dashboardResponse: List<Result>): Completable
    fun getAllDashBoard(): Observable<List<Result>>


}
