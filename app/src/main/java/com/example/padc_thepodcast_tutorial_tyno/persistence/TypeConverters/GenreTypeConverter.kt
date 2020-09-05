package com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters

import androidx.room.TypeConverter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.ExtraVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreTypeConverter {
    @TypeConverter
    fun toString(genreList: ArrayList<Int>): String {
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun toJsonList(genreStr: String): ArrayList<Int> {
        val genreListType = object : TypeToken<ArrayList<Int>>() {}.type
        return Gson().fromJson(genreStr, genreListType)
    }
}