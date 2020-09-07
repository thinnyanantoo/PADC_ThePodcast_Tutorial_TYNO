package com.example.padc_thepodcast_tutorial_tyno.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.data.vos.DownloadVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodeDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastVO
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.DetailPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls.DetailPresenterImpl
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DetailView
import com.example.padc_thepodcast_tutorial_tyno.persistence.daos.UpNextPlayListDao
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.MiniPlayBackViewPod
import kotlinx.android.synthetic.main.activity_detail.*
import kotlin.math.min

class DetailActivity : BaseActivity(), DetailView {

    private lateinit var mPresenter: DetailPresenter
    private var mPodCastModel: PodCastModel = PodCastModelImpl
    private lateinit var miniPlayBackViewPod: MiniPlayBackViewPod
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

        miniPlayBackViewPod = vpMiniPlayback as MiniPlayBackViewPod

        setUpPresenter()
        disableSwipeRefresh()
        podcastId = intent.getStringExtra(PODCAST_KEY).toString()
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
        miniPlayBackViewPod.bindData(episodeDetailVO)
    }

    override fun showbMiniPlayBack(episodeDetailVO: EpisodeDetailVO) {
        miniPlayBackViewPod.bindData(episodeDetailVO)
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

//    override fun onDestroy() {
//        miniPlayBackViewPod.onDestroy()
//        super.onDestroy()
//    }
}
