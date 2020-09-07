package com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters

import androidx.room.TypeConverter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.ExtraVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ExtraVoTypeConverters {
    @TypeConverter
    fun toString(dataList:ExtraVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): ExtraVO{
        val dataListType = object : TypeToken<ExtraVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}