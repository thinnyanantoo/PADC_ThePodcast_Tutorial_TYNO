package com.example.padc_thepodcast_tutorial_tyno.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.BaseView
import kotlinx.android.synthetic.main.activity_detail.*

abstract class BaseActivity : AppCompatActivity(), BaseView {
    fun displayEmptyView() {
    }

}