package com.example.padc_thepodcast_tutorial_tyno.data.vos

import com.google.gson.annotations.SerializedName

data class LookingForVO (
    @SerializedName("sponsors") var sponsors: Boolean,
    @SerializedName("guests")var guests: Boolean,
    @SerializedName("cohosts")var cohosts: Boolean,
    @SerializedName("cross_promotion")var crossPromotion : Boolean
)