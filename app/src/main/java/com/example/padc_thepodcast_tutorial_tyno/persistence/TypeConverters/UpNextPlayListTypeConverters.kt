package com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters

import androidx.room.TypeConverter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.UpNextHomeViewPod
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UpNextPlayListTypeConverters {
    @TypeConverter
    fun toString(upNextList: UpNextPlayListVO): String {
        return Gson().toJson(upNextList)
    }

    @TypeConverter
    fun toJsonList(upNextJsoStr: String): UpNextPlayListVO {
        val upNextListType = object : TypeToken<UpNextPlayListVO>() {}.type
        return Gson().fromJson(upNextJsoStr, upNextListType)
    }

}