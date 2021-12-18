package com.sunking.lapo.notification.LocalData.Dao

import androidx.room.TypeConverter
import com.example.motilal.model.BuiltBy
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


public class BuiltByConverter {

    @TypeConverter
    fun fromBuiltByList(list: List<BuiltBy>?): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<BuiltBy>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toBuiltByList(string: String?): List<BuiltBy>? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<BuiltBy>>() {

        }.type
        return gson.fromJson(string, type)
    }

}