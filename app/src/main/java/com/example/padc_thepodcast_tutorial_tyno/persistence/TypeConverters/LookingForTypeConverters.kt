package com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters

import androidx.room.TypeConverter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.LookingForVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LookingForTypeConverters {
    @TypeConverter
    fun toString(dataList: LookingForVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): LookingForVO {
        val dataListType = object : TypeToken<LookingForVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}