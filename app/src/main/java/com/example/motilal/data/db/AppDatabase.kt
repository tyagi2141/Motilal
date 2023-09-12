package com.example.motilal.data.db

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.motilal.data.db.dao.DashboardDao
import com.example.motilal.model.DashboardResponse
import com.example.motilal.model.Result
import com.sunking.lapo.notification.LocalData.Dao.BuiltByConverter


@Database(
    entities = [
        Result::class
    ],
    version = 1
)
@TypeConverters(
    BuiltByConverter::class
)

abstract class AppDatabase() : RoomDatabase(), Parcelable {

    abstract fun dashboardDao(): DashboardDao

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }


}