package com.example.padc_thepodcast_tutorial_tyno.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_pod_empty.view.*

class EmptyViewPod @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, delfStyleAttr: Int = 0
) : CardView(context, attr, delfStyleAttr) {

    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setEmptyData(emptyMessage: String, emptyImageUrl: String) {
        tvEmpty.text = emptyMessage

        Glide.with(context)
            .load(emptyImageUrl)
            .into(ivEmptyImage)
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    private fun setUpListener() {
        btnTryAgain.setOnClickListener {
           // mDelegate?.onTapTryAgain()
        }

    }

    interface Delegate {
      //  fun onTapTryAgain()
    }
}
