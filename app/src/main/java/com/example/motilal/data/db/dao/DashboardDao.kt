package com.example.motilal.data.db.dao

import androidx.room.*
import com.example.motilal.model.DashboardResponse
import io.reactivex.Completable
import io.reactivex.Observable


@Dao
interface DashboardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(dashboardResponse: List<DashboardResponse>): Completable

    @TypeConverter
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dashboardResponse: DashboardResponse): Completable

    @Query("SELECT * FROM DashboardResponse")
    fun getAll(): Observable<List<DashboardResponse>>


}