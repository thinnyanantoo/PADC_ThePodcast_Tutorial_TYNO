package com.example.padc_thepodcast_tutorial_tyno.data.vos

import com.google.gson.annotations.SerializedName

data class ExtraVO (
    @SerializedName("twitter_handle")var twitterHandle: String? = "",
    @SerializedName("facebook_handle")var facebookHandle : String? = "",
    @SerializedName("instagram_handle")var instagramHandle : String? ="",
    @SerializedName("wechat_handle")var wechatHandle: String? = "",
    @SerializedName("patreon_handle")var patreonHandle : String? = "",
    @SerializedName("youtube_url")var youtubeUrl: String? = "",
    @SerializedName("linkedin_url")var linkedInUrl : String? = "",
    @SerializedName("spotify_url")var spotifyUrl: String? = "",
    @SerializedName("google_url")var googleUrl : String? = "",
    @SerializedName("url1")var url1: String? = "",
    @SerializedName("url2")var url2: String?="",
    @SerializedName("url3")var url3: String? = ""
)