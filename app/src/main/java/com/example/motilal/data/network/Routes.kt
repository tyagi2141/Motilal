package com.example.motilal.data.network

import com.example.motilal.model.DashboardResponse
import com.example.motilal.model.Result
import com.example.motilal.util.CommonResponseModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface Routes {


    @GET("repositories")
    fun getData(
        @Query("since") since: String = "daily"
    ): Single<List<DashboardResponse>>


}