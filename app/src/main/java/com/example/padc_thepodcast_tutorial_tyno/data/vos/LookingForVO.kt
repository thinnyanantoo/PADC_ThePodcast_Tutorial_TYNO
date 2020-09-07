package com.example.padc_thepodcast_tutorial_tyno.data.vos

import com.google.gson.annotations.SerializedName

data class LookingForVO (
    @SerializedName("cohosts")val cohosts: Boolean,
    @SerializedName("cross_promotion")val cross_promotion: Boolean,
    @SerializedName("guests")val guests: Boolean,
    @SerializedName("sponsors")val sponsors: Boolean
)