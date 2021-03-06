package com.example.padc_thepodcast_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView


class MiniPlayBackViewPod @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, delfStyleAttr: Int = 0
) : CardView(context, attr, delfStyleAttr) {

  //  private var mDelegate: PlaybackHomeViewPod.Delegate? = null
//    private var TAG = "ERROR"
//    private lateinit var simpleExoPlayer: SimpleExoPlayer
//    private lateinit var mediaSource: MediaSource
//    private lateinit var dataSourceFactory: DefaultDataSourceFactory
//    private lateinit var loadControl : LoadControl
//
//    private var mpodCastData: EpisodeDetailVO ? = null
//
//    companion object{
//        const val RADIO_URL =
//            "http://kastos.cdnstream.com/1345_32"
//
//    }
//
//    fun bindData(data : EpisodeDetailVO?){
//            mpodCastData = data
//          tvaudioLength.text = mpodCastData?.audio_length_sec
//            onCreatePlayBack()
//
//        }
//    //private var mdownloadData : DownloadVO? = null
//
////    fun bindDownloadData(data : DownloadVO?){
////        mdownloadData = data
////        onCreatePlayBack()
////    }
//
//
//    fun onCreatePlayBack() {
//        loadControl = DefaultLoadControl()
//
//        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(context)
//        dataSourceFactory = DefaultDataSourceFactory(context, Util.getUserAgent(context, "exoPlayerSample"))
//
//       // mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(mpodCastData?.data?.audio.toString()))
//       // mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse( RADIO_URL))
//
//        mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse( RADIO_URL))
//
//        with(simpleExoPlayer) {
//            prepare(mediaSource, false, false)
//            btnPlay.setOnClickListener {
//                // mDelegate?.onTapPlay()
//                playWhenReady = true
//                btnPlay.visibility = android.view.View.GONE
//                btnPause.visibility = android.view.View.VISIBLE
//            }
//
//            btnPause.setOnClickListener {
//                //    mDelegate?.onTapPause()
//                playWhenReady = false
//                btnPause.visibility = android.view.View.GONE
//                btnPlay.visibility = android.view.View.VISIBLE
//            }
//        }
//
//
//        simpleExoPlayer.addListener(object : Player.EventListener {
//            override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters) {
//                Log.e(TAG, "onPlaybackParametersChanged")
//            }
//
//            override fun onTracksChanged(
//                trackGroups: TrackGroupArray,
//                trackSelections: TrackSelectionArray
//            ) {
//                Log.e(TAG, "onTracksChanged:")
//            }
//
//            override fun onPlayerError(error: ExoPlaybackException) {
//                Log.e(TAG, "onPlayerError")
//            }
//
//            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
//                when (playbackState) {
//                    PlaybackState.STATE_BUFFERING -> {
//                        straightProgress.visibility = View.VISIBLE
//                        Log.e(TAG, "onPlayerStateChanged - STATE_BUFFERING")
//                    }
//                    Player.STATE_READY -> {
//                        straightProgress.visibility = View.VISIBLE
//                        Log.e(TAG, "onPlayerStateChanged - STATE_READY")
//
//                    }
//                    Player.STATE_IDLE -> {
//                        Log.e(TAG, "onPlayerStateChanged - STATE_READY")
//                    }
//                    Player.STATE_ENDED -> {
//                        straightProgress.visibility = View.VISIBLE
//                        Log.e(TAG, "onPlayerStateChanged - STATE_ENDED")
//                    }
//
//                }
//            }
//
//            override fun onLoadingChanged(isLoading: Boolean) {
//                Log.e(TAG, "onLoadingChanged")
//            }
//
//            override fun onPositionDiscontinuity(reason: Int) {
//                Log.e(TAG, "onPositionDiscontinuity")
//            }
//
//            override fun onRepeatModeChanged(repeatMode: Int) {
//                Log.e(TAG, "onRepeatModeChanged")
//            }
//
//            override fun onTimelineChanged(timeline: Timeline, reason: Int) {
//                Log.e(TAG, "onTimelineChanged")
//            }
//        })

    }
//    fun onDestroy() {
//        simpleExoPlayer.playWhenReady = false
//    }
