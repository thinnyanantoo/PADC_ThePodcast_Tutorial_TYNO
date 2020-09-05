package com.example.padc_thepodcast_tutorial_tyno.views.viewpods

import android.content.Context
import android.media.session.PlaybackState.STATE_BUFFERING
import android.net.Uri
import android.net.sip.SipSession
import android.os.Handler
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.Player.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.upstream.*
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.play_back_view_pod.view.*

class PlaybackHomeViewPod @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, delfStyleAttr: Int = 0
) : CardView(context, attr, delfStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
        onCreatePlayBack()
    }

    private var mDelegate: Delegate? = null
    private var TAG = "ERROR"
    private lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var mediaSource: MediaSource
    private lateinit var dataSourceFactory: DefaultDataSourceFactory
    private var playbackPosition: Long = 0
    private lateinit var loadControl : LoadControl

    private var mpodCastData: RandomPodCastVO? = null

    companion object {
        const val RADIO_URL =
            "http://kastos.cdnstream.com/1345_32"
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    fun setBindData(data : RandomPodCastVO?, context : Context){
        mpodCastData = data
        Glide.with(context)
            .load(data?.image)
            .into(randomImage)

    tvDetailInRandom.text = data?.description
        tvTitleInRandom.text = data?.title
        tvTitleDesInRandom.text = data?.title

        onCreatePlayBack()

    }


//    fun initExoPlayer() {
//        simpleExoPlayer = SimpleExoPlayer.Builder(context).build()
//
//        exoPlayer.visibility = View.VISIBLE
//
//
//
//
//        val dataSource: DataSource.Factory = DefaultDataSourceFactory(context,
//            Util.getUserAgent(context, "test"))
//
//        mediaSource = ProgressiveMediaSource.Factory(dataSource)
//            .createMediaSource(Uri.parse(RADIO_URL))
//
//
//        val extractorsFactory: DefaultExtractorsFactory = DefaultExtractorsFactory().setConstantBitrateSeekingEnabled(true)
//        val progressiveMediaSource: ProgressiveMediaSource =
//            ProgressiveMediaSource.Factory(dataSource, extractorsFactory).createMediaSource(Uri.parse(
//                RADIO_URL))
//
//
//        simpleExoPlayer.prepare(progressiveMediaSource)
//
//        btnPlay.setOnClickListener {
//            // mDelegate?.onTapPlay()
//            simpleExoPlayer.playWhenReady= true
//            btnPlay.visibility = View.GONE
//            btnPause.visibility = View.VISIBLE
//        }
//
//        btnPause.setOnClickListener {
//            //    mDelegate?.onTapPause()
//            simpleExoPlayer.playWhenReady = false
//            btnPause.visibility = View.GONE
//            btnPlay.visibility = View.VISIBLE
//        }
//    }

    var position : Long = 1L
    fun onCreatePlayBack() {

        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(context)
        dataSourceFactory = DefaultDataSourceFactory(context, Util.getUserAgent(context, "exoPlayerSample"))

        mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(mpodCastData?.audio.toString()))

        with(simpleExoPlayer) {
            prepare(mediaSource, false, false)
            position = currentPosition
            btnPlay.setOnClickListener {
                playWhenReady = true
              //  mDelegate?.onTapPlay()
                btnPlay.visibility = View.GONE
                btnPause.visibility = View.VISIBLE
            }

            btnPause.setOnClickListener {
                playWhenReady = false
              // mDelegate?.onTapPause()
                btnPause.visibility = View.GONE
                btnPlay.visibility = View.VISIBLE
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
                    STATE_BUFFERING -> {
                        exoPlayerProgress.visibility = View.VISIBLE
                        exoPlayerProgress.setProgress(position.toInt())
                        Log.e(TAG, "onPlayerStateChanged - STATE_BUFFERING")
                    }
                    STATE_READY -> {
                        exoPlayerProgress.visibility = View.VISIBLE
                        Log.e(TAG, "onPlayerStateChanged - STATE_READY")
                        exoPlayerProgress.setProgress(position.toInt())

                    }
                    STATE_IDLE -> {
                        Log.e(TAG, "onPlayerStateChanged - STATE_READY")
                        exoPlayerProgress.setProgress(position.toInt())
                    }
                    STATE_ENDED -> {
                        exoPlayerProgress.visibility = View.VISIBLE
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

//    private fun preparePlayer(url: String, type: String) {
//        val uri = Uri.parse(url)
//        val mediaSource = buildMediaSource(uri, type)
//        simpleExoPlayer.prepare(mediaSource)
//    }

//    fun releasePlayer() {
//        playbackPosition = simpleExoPlayer.currentPosition
//        simpleExoPlayer.release()
//    }

    private fun buildMediaSource(uri: Uri, type: String): MediaSource {
        return if (type == "dash") {
            DashMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri)
        } else {
            ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri)
        }
    }

    fun onDestroy() {
        simpleExoPlayer.playWhenReady = false
    }

    fun setPlayBackFalse(){
        simpleExoPlayer.playWhenReady = false
    }

    fun setPlayBackTrue(){
        simpleExoPlayer.playWhenReady = true
    }

    interface Delegate {
        fun onTapPlay()
        fun onTapPause()
        fun onTapTenSecond()
        fun onTapThirtySecond()
    }
}