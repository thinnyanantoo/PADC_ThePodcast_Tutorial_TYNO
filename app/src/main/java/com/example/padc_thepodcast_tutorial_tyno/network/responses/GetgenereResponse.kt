package com.example.padc_thepodcast_tutorial_tyno.network.responses

import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.data.vos.GenereVO
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.GenreTypeConverter
import com.google.gson.annotations.SerializedName

data class GetgenereResponse (
    @SerializedName("genres")val generes : ArrayList<GenereVO>? = arrayListOf()
)