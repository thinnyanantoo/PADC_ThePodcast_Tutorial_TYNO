package com.example.padc_thepodcast_tutorial_tyno.delegates

import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.PlaybackHomeViewPod

interface ItemDelegate : PlaybackHomeViewPod.Delegate {
    fun onTapItem()
}