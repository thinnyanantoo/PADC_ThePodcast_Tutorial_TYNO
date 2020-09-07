package com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters

import androidx.room.TypeConverter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastDetailVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PodCastDetialVOTypeConverter {
    @TypeConverter
    fun toString(podCastDetailList: PodCastDetailVO): String {
        return Gson().toJson(podCastDetailList)
    }
    @TypeConverter
    fun toJsonList(podCastDetailStr: String): PodCastDetailVO {
        val podCastDetailListType = object : TypeToken<PodCastDetailVO>() {}.type
        return Gson().fromJson(podCastDetailStr, podCastDetailListType)
    }

}