package com.example.motilal.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class DashboardResponse(

    @SerializedName("result" ) var result : List<Result>?= emptyList()

) : Parcelable {

}