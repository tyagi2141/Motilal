package com.example.motilal.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/*@Parcelize
data class Result (
   // val list : List<DashboardResponse>
    @SerializedName("result" ) var list : List<DashboardResponse> = emptyList()

) : Parcelable */

@Entity
@Parcelize
data class Result(

    @PrimaryKey
    @SerializedName("author") var author: String,
    @SerializedName("name") var name: String? = null,
    @SerializedName("avatar") var avatar: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("language") var language: String? = null,
    @SerializedName("languageColor") var languageColor: String? = null,
    @SerializedName("stars") var stars: Int? = null,
    @SerializedName("forks") var forks: Int? = null,
    @SerializedName("currentPeriodStars") var currentPeriodStars: Int? = null,
    @SerializedName("builtBy") var builtBy: List<BuiltBy> = emptyList()
) : Parcelable