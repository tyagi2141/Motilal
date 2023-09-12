package com.example.motilal.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class BuiltBy(
    @SerializedName("href") var href: String? = null,
    @SerializedName("avatar") var avatar: String? = null,
    @SerializedName("username") var username: String? = null
) : Parcelable