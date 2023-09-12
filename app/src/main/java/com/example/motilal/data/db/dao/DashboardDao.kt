package com.example.motilal.data.db.dao

import androidx.room.*
import com.example.motilal.model.DashboardResponse
import com.example.motilal.model.Result
import io.reactivex.Completable
import io.reactivex.Observable


@Dao
interface DashboardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(dashboardResponse: List<Result>): Completable

    @TypeConverter
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dashboardResponse: Result): Completable

    @Query("SELECT * FROM Result")
    fun getAll(): Observable<List<Result>>


}