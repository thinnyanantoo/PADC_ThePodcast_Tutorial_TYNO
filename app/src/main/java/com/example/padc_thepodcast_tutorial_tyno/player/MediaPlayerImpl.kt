package com.example.padc_thepodcast_tutorial_tyno.player

import android.content.Context
import android.net.Uri
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.fragments.HomeFragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util

class MediaPlayerImpl : MediaPlayer {

    private lateinit var exoPlayer: ExoPlayer
    private lateinit var context: Context
    override fun play(url: String) {
        val userAgent = Util.getUserAgent(context,context.getString(R.string.app_name))
        val httpDataSourceFactory = DefaultHttpDataSourceFactory(
            userAgent,DefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS,
            DefaultHttpDataSource.DEFAULT_READ_TIMEOUT_MILLIS,true
        )
        val mediaSource = ProgressiveMediaSource.Factory(DefaultDataSourceFactory(context, null ,httpDataSourceFactory))
            .createMediaSource(Uri.parse(url))

        exoPlayer.prepare(mediaSource)
        exoPlayer.playWhenReady = false
    }

    override fun getPlayerImpl(context: Context): ExoPlayer {
        this.context = context
        initializePlayer()
        return exoPlayer
    }

    override fun releasePlayer() {
        exoPlayer.playWhenReady = false
        exoPlayer.stop()
        exoPlayer.release()
    }

    override fun playFalse() {
    }

    private fun initializePlayer(){
        val trackSelector = DefaultTrackSelector(context)
            trackSelector.setParameters(trackSelector.buildUponParameters().setMaxVideoSizeSd())

        exoPlayer = SimpleExoPlayer.Builder(context)
            .setTrackSelector(trackSelector)
            .build()

    }
}