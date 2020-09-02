package com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters

import androidx.room.TypeConverter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PodCastTypeConverter {
    @TypeConverter
    fun toString(lookingForList: PodCastVO): String {
        return Gson().toJson(lookingForList)
    }

    @TypeConverter
    fun toJsonList(lookingForStr: String): PodCastVO{
        val lookingForListType = object : TypeToken<PodCastVO>() {}.type
        return Gson().fromJson(lookingForStr, lookingForListType)
    }
}