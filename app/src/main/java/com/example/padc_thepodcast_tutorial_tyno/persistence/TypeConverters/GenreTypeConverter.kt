package com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters

import androidx.room.TypeConverter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.ExtraVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreTypeConverter {
    @TypeConverter
    fun toString(commentList: List<Int>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): List<Int> {
        val commentListType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}