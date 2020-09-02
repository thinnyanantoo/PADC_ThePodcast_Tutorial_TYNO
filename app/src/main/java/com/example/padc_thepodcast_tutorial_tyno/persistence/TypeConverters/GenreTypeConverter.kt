package com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters

import androidx.room.TypeConverter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.ExtraVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreTypeConverter {
    @TypeConverter
    fun toString(genreList: List<Int>): String {
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun toJsonList(genreStr: String): List<Int> {
        val genreListType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(genreStr, genreListType)
    }
}