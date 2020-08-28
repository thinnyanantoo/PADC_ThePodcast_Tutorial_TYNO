package com.example.padc_thepodcast_tutorial_tyno.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.withStyledAttributes
import com.example.padc_thepodcast_tutorial_tyno.R
import java.math.BigDecimal
import kotlin.math.roundToInt

class StraightProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()

    private val progressPaint = Paint()

    var mStrokeWidth = 20
    var mStrokeHeight = 20

   // var progressSet = 0
    var progresss = 0
    var colorfill = Color.GRAY

    init {
        context.withStyledAttributes(attrs, R.styleable.StraightProgressView) {
             progresss = getInteger(R.styleable.StraightProgressView_strProgress, 0)
            colorfill = getColor(R.styleable.StraightProgressView_color, Color.GRAY)
            mStrokeWidth =
                getDimension(R.styleable.StraightProgressView_stroke_width, 1.0f).roundToInt()
            mStrokeHeight =
                getDimension(R.styleable.StraightProgressView_stroke_height, 1.0f).roundToInt()
        }
    }

//    private fun setProgress(progress: Int) {
//        progressSet =  progress
//    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.apply {
            progressPaint.strokeWidth = 20f
            paint.strokeWidth = 20f
            paint.color = Color.GRAY
            progressPaint.style = Paint.Style.FILL
            progressPaint.color = colorfill
        }

        canvas?.drawLine(0f, 0f, width.toFloat(), 0f, paint)
        val calculated = BigDecimal(progresss).divide(BigDecimal(100)).multiply(BigDecimal(width))
        Log.d("straight", "$calculated")
        canvas?.drawLine(0f, 0f, calculated.toFloat(), 0f, progressPaint)
    }
}

