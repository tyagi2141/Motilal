package com.example.motilal.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result (
    val list : List<DashboardResponse>
) : Parcelable