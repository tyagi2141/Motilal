package com.example.motilal.data.repo

import androidx.lifecycle.LiveData
import com.example.motilal.model.DashboardResponse
import com.example.motilal.model.Result
import com.example.motilal.util.CommonResponseModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface DataRepository {

    fun getData(): Single<List<DashboardResponse>>

    fun insertAllDashboard(dashboardResponse: List<DashboardResponse>): Completable

    fun getAllDashBoard(): Observable<List<DashboardResponse>>


}
