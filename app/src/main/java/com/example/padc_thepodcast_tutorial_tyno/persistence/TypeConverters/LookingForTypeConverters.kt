package com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters

import androidx.room.TypeConverter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.LookingForVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LookingForTypeConverters {
    @TypeConverter
    fun toString(lookingForList: LookingForVO): String {
        return Gson().toJson(lookingForList)
    }

    @TypeConverter
    fun toJsonList(lookingForStr: String): LookingForVO {
        val lookingForListType = object : TypeToken<LookingForVO>() {}.type
        return Gson().fromJson(lookingForStr, lookingForListType)
    }
}