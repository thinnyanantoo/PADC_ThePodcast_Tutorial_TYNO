package com.example.padc_thepodcast_tutorial_tyno.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.DetailPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls.DetailPresenterImpl
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DetailView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.mini_playback_view_pod.*

class DetailActivity : BaseActivity(), DetailView {

    private lateinit var mPresenter: DetailPresenter

    companion object {
        val PODCAST_KEY = "PODCAST_KEY"
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            // intent.putExtra(PODCAST_KEY,podcastId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUpPresenter()
        disableSwipeRefresh()
        //   straightProgress.progressSet = 40
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    override fun showDeail() {

    }

    override fun enableSwipeRefresh() {

    }

    override fun disableSwipeRefresh() {
    }
}