package com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters

import androidx.room.TypeConverter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.ExtraVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ExtraVoTypeConverters {
    @TypeConverter
    fun toString(extraList: ExtraVO): String {
        return Gson().toJson(extraList)
    }

    @TypeConverter
    fun toJsonList(extraStr: String): ExtraVO {
        val extraListType = object : TypeToken<ExtraVO>() {}.type
        return Gson().fromJson(extraStr, extraListType)
    }
}