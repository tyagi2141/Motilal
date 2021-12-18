package com.example.motilal.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class BuiltBy (
    @SerializedName("href") val href : String,
    @SerializedName("avatar") val avatar : String,
    @SerializedName("username") val username : String
) : Parcelable