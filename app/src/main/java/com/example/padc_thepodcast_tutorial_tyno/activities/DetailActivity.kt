package com.example.padc_thepodcast_tutorial_tyno.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DetailView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.mini_playback_view_pod.*

class DetailActivity : AppCompatActivity(), DetailView {

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

        disableSwipeRefresh()
        //   straightProgress.progressSet = 40
    }

    override fun showDeail() {

    }

    override fun displayEmptyView() {

    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }
}