package com.example.motilal.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Entity
@Parcelize
data class DashboardResponse (


    @PrimaryKey
    @SerializedName("author") val author : String,
    @SerializedName("name") val name : String,
    @SerializedName("avatar") val avatar : String,
    @SerializedName("url") val url : String,
    @SerializedName("description") val description : String,
    @SerializedName("language") val language : String,
    @SerializedName("languageColor") val languageColor : String,
    @SerializedName("stars") val stars : Int,
    @SerializedName("forks") val forks : Int,
    @SerializedName("currentPeriodStars") val currentPeriodStars : Int,
    @SerializedName("builtBy") val builtBy : List<BuiltBy>
) : Parcelable {
    override fun toString(): String {
        return "DashboardResponse(author='$author', name='$name', avatar='$avatar', url='$url', description='$description', language='$language', languageColor='$languageColor', stars=$stars, forks=$forks, currentPeriodStars=$currentPeriodStars, builtBy=$builtBy)"
    }
}