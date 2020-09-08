package com.example.padc_thepodcast_tutorial_tyno.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodeDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.DetailPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls.DetailPresenterImpl
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DetailView
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.mini_playback_view_pod.*

class DetailActivity : BaseActivity(), DetailView {

    private lateinit var mPresenter: DetailPresenter
    private var mPodCastModel: PodCastModel = PodCastModelImpl
    var podcastId: String? = ""

    companion object {
        val PODCAST_KEY = "PODCAST_KEY"
        fun newIntent(context: Context, id: String?): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(PODCAST_KEY, id)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUpPresenter()
        disableSwipeRefresh()
        podcastId = intent.getStringExtra(PODCAST_KEY).toString()
       setData()
        mPresenter.onUiReady(podcastId!!, this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun showDeail(episodeDetailVO: EpisodeDetailVO) {
        Glide.with(this)
            .load(episodeDetailVO.image)
            .into(ivDetail)
        tvDetailDescription.text = Html.fromHtml(episodeDetailVO.description)
        tvTimeDetail.text = episodeDetailVO.audio_length_sec + "\tm"
        tvTitleDetail.text = episodeDetailVO.title
        miniPlaybackControlView.player = mPresenter.getPlayer().getPlayerImpl(this)
        mPresenter.play(episodeDetailVO.audio)
    }

    private fun setData(){
        val id = intent.getStringExtra(PODCAST_KEY)
        mPodCastModel.getUpNextById(id.toString())
            .observe(this, Observer {
                it?.let { data ->
                    bindData(data)}
            })
    }

    private fun bindData(episodePlaylistVO: EpisodePlaylistVO){
        Glide.with(this)
            .load(episodePlaylistVO.data!!.image)
            .into(ivDetail)
        tvDetailDescription.text = episodePlaylistVO.data!!.description
        tvTimeDetail.text = episodePlaylistVO.data!!.audioLengthSec + "\tm"
        tvTitleDetail.text = episodePlaylistVO.data!!.title
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            mPresenter.getPlayer().getPlayerImpl(this)
        }
    }

    override fun onResume() {
        super.onResume()
        hideSystemUi()
        if(Util.SDK_INT<=23)
        mPresenter.getPlayer().getPlayerImpl(this)
    }

    override fun onStop() {
        super.onStop()
        if(Util.SDK_INT <= 23)
        mPresenter.releasePlayer()
    }

    override fun onPause() {
        super.onPause()
        if(Util.SDK_INT <= 23)
        mPresenter.releasePlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.releasePlayer()
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        miniPlaybackControlView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

    }
}
