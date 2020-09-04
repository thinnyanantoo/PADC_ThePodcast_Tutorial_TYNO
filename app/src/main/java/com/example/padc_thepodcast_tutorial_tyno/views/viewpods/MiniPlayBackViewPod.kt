package com.example.padc_thepodcast_tutorial_tyno.views.viewpods

import android.content.Context
import android.media.session.PlaybackState
import android.net.Uri
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.cardview.widget.CardView
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodeDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.mini_playback_view_pod.view.*
import kotlinx.android.synthetic.main.play_back_view_pod.view.*
import kotlinx.android.synthetic.main.play_back_view_pod.view.btnPause
import kotlinx.android.synthetic.main.play_back_view_pod.view.btnPlay

class MiniPlayBackViewPod @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, delfStyleAttr: Int = 0
) : CardView(context, attr, delfStyleAttr) {

    private var mDelegate: PlaybackHomeViewPod.Delegate? = null
    private var TAG = "ERROR"
    private lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var mediaSource: MediaSource
    private lateinit var dataSourceFactory: DefaultDataSourceFactory
    private lateinit var loadControl : LoadControl

    private var mpodCastData: EpisodePlaylistVO ? = null

    fun bindData(data : EpisodePlaylistVO?){
        mpodCastData = data
        tvaudioLength.text = data?.data?.audioLengthSec.toString()

        onCreatePlayBack()
    }

    fun onCreatePlayBack() {
        loadControl = DefaultLoadControl()

        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(context)
        dataSourceFactory = DefaultDataSourceFactory(context, Util.getUserAgent(context, "exoPlayerSample"))

        mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(mpodCastData?.data?.audio.toString()))

        with(simpleExoPlayer) {
            prepare(mediaSource, false, false)
            btnPlay.setOnClickListener {
                // mDelegate?.onTapPlay()
                playWhenReady = true
                btnPlay.visibility = android.view.View.GONE
                btnPause.visibility = android.view.View.VISIBLE
            }

            btnPause.setOnClickListener {
                //    mDelegate?.onTapPause()
                playWhenReady = false
                btnPause.visibility = android.view.View.GONE
                btnPlay.visibility = android.view.View.VISIBLE
            }
        }

        simpleExoPlayer.addListener(object : Player.EventListener {
            override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters) {
                Log.e(TAG, "onPlaybackParametersChanged")
            }

            override fun onTracksChanged(
                trackGroups: TrackGroupArray,
                trackSelections: TrackSelectionArray
            ) {
                Log.e(TAG, "onTracksChanged:")
            }

            override fun onPlayerError(error: ExoPlaybackException) {
                Log.e(TAG, "onPlayerError")
            }

            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                when (playbackState) {
                    PlaybackState.STATE_BUFFERING -> {
                        exoPlayer.visibility = View.VISIBLE
                        Log.e(TAG, "onPlayerStateChanged - STATE_BUFFERING")
                    }
                    Player.STATE_READY -> {
                        exoPlayer.visibility = View.VISIBLE
                        Log.e(TAG, "onPlayerStateChanged - STATE_READY")

                    }
                    Player.STATE_IDLE -> {
                        Log.e(TAG, "onPlayerStateChanged - STATE_READY")
                    }
                    Player.STATE_ENDED -> {
                        exoPlayer.visibility = View.VISIBLE
                        Log.e(TAG, "onPlayerStateChanged - STATE_ENDED")
                    }

                }
            }

            override fun onLoadingChanged(isLoading: Boolean) {
                Log.e(TAG, "onLoadingChanged")
            }

            override fun onPositionDiscontinuity(reason: Int) {
                Log.e(TAG, "onPositionDiscontinuity")
            }

            override fun onRepeatModeChanged(repeatMode: Int) {
                Log.e(TAG, "onRepeatModeChanged")
            }

            override fun onTimelineChanged(timeline: Timeline, reason: Int) {
                Log.e(TAG, "onTimelineChanged")
            }
        })
    }

}