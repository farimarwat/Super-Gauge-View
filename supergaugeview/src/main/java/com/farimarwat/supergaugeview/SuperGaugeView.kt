package com.farimarwat.supergaugeview

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.dinuscxj.progressbar.CircleProgressBar


class SuperGaugeView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private val mProgress = 0
    private var maxProgress=120f;
    private lateinit var mCircleProgressBar: CircleProgressBar
    private lateinit var mCircleProgressBarShadowHide: CircleProgressBar
    private lateinit var imageViewNeedle: ImageView
    private lateinit var textViewCurrentDbCPB: TextView
    private val textViewCPBLabels = arrayOfNulls<TextView>(9)
    private val textViewCPBLabelValues = intArrayOf(0, 20, 30, 50, 60, 70, 90, 100, 120)
    private lateinit var mRelativeLayoutGaugeCurrentDb: RelativeLayout
    private var animatorValueOnGauge: ValueAnimator

    private var mGaugeListener:GaugeListener? = null

    //Attributes
    private var progressbackground = GAUGE_KEYHOLE_1

    //End Attributes
    init {
        inflate(context, R.layout.gaugeview, this)
        animatorValueOnGauge = ValueAnimator.ofFloat(121f)
        animatorValueOnGauge.repeatCount = ValueAnimator.INFINITE
        animatorValueOnGauge.addUpdateListener { animation ->
            var progress = animation.animatedValue as Float
            val txt_progress = progress
            mGaugeListener?.let { listener ->
                listener.onProgress(txt_progress)
            }
            if(progress > maxProgress) {
                progress = maxProgress
            }
            val newProgress=(progress/maxProgress*120)
            mCircleProgressBar.progress = newProgress.toInt()
            mCircleProgressBarShadowHide.progress = newProgress.toInt()
            imageViewNeedle.rotation = (2.19166667 * newProgress).toFloat()
            textViewCurrentDbCPB.text = String.format("%.2f", txt_progress)
            for (i in 0..8) {
                if (textViewCPBLabelValues[i] < progress) textViewCPBLabels[i]?.setTextColor(
                    ContextCompat.getColor(context, R.color.colorActiveGaugeText)
                ) else textViewCPBLabels[i]?.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorNotActiveGaugeText
                    )
                )
            }
        }
        animatorValueOnGauge.duration = DURATION.toLong()
        animatorValueOnGauge.repeatCount = 0
        setupAttributes(attrs)
    }

    fun setupAttributes(attrs: AttributeSet) {
        val typedarray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.SuperGaugeView, 0, 0
        )
        //gauge text
        val txtGaugeText = findViewById<TextView>(R.id.textViewDecibelCPB)
        val strGaugeText = typedarray.getString(R.styleable.SuperGaugeView_gaugeText)
        txtGaugeText.text = strGaugeText
        //
        //gauge text color
        val txtgaugetextcolor = typedarray.getColor(R.styleable.SuperGaugeView_gaugeTextColor,Color.GRAY)
        txtGaugeText.setTextColor(txtgaugetextcolor)
        //

        //duration
        val duration = typedarray.getInteger(
            R.styleable.SuperGaugeView_duration, DURATION
        )
        animatorValueOnGauge.duration = duration.toLong()
        //

        //progress background
        val int_background = typedarray.getInteger(
            R.styleable.SuperGaugeView_progressBackground, progressbackground
        )
        val img_progress = findViewById<ImageView>(R.id.progressbar)
        when(int_background){
            GAUGE_KEYHOLE_1 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_1)
                )
            }
            GAUGE_KEYHOLE_2 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_2)
                )
            }
            GAUGE_KEYHOLE_3 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_3)
                )
            }
            GAUGE_KEYHOLE_4 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_4)
                )
            }
            GAUGE_KEYHOLE_5 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_5)
                )
            }
            GAUGE_KEYHOLE_6 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_6)
                )
            }
            GAUGE_KEYHOLE_7 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_7)
                )
            }
            GAUGE_KEYHOLE_8 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_8)
                )
            }
            GAUGE_KEYHOLE_9 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_9)
                )
            }
            GAUGE_KEYHOLE_10 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_10)
                )
            }
            GAUGE_KEYHOLE_11 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_11)
                )
            }
            GAUGE_KEYHOLE_12 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_12)
                )
            }
            GAUGE_KEYHOLE_13 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_13)
                )
            }
            GAUGE_KEYHOLE_14 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_14)
                )
            }
            GAUGE_KEYHOLE_15 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_15)
                )
            }
            GAUGE_KEYHOLE_16 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_16)
                )
            }
            GAUGE_KEYHOLE_17 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_17)
                )
            }
            GAUGE_KEYHOLE_18 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_18)
                )
            }
            GAUGE_KEYHOLE_19 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_19)
                )
            }
            GAUGE_KEYHOLE_20 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_20)
                )
            }
            else ->{
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_1)
                )
            }
        }
        //

        //gauge bottom icon
        val img_gaugebottomicon = findViewById<ImageView>(R.id.imageDecibelCPB)
        val gaugebottomicon = typedarray.getDrawable(
            R.styleable.SuperGaugeView_gaugebottomicon
        )
        gaugebottomicon?.let {
            img_gaugebottomicon.setImageDrawable(
                it
            )
        }
        val gaugebottomiconcolor = typedarray.getColor(
            R.styleable.SuperGaugeView_gaugebottomiconcolor,
            GAUGEBOTTOMICON_COLOR
        )
        img_gaugebottomicon.setColorFilter(gaugebottomiconcolor)
    }

    fun getDuration():Long{
        return animatorValueOnGauge.duration
    }
    fun setDuration(duration:Long){
        animatorValueOnGauge.duration = duration
    }
    fun setGaugeText(value:String){
        val txt_gaugetext = findViewById<TextView>(R.id.textViewDecibelCPB)
        txt_gaugetext.text = value
    }
    fun getGaugeText():String{
        val txt_gaugetext = findViewById<TextView>(R.id.textViewDecibelCPB)
        return txt_gaugetext.text.toString()
    }

    fun setProgressBackground(background:Int){
        val img_progress = findViewById<ImageView>(R.id.progressbar)
        when(background){
            GAUGE_KEYHOLE_1 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_1)
                )
            }
            GAUGE_KEYHOLE_2 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_2)
                )
            }
            GAUGE_KEYHOLE_3 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_3)
                )
            }
            GAUGE_KEYHOLE_4 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_4)
                )
            }
            GAUGE_KEYHOLE_5 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_5)
                )
            }
            GAUGE_KEYHOLE_6 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_6)
                )
            }
            GAUGE_KEYHOLE_7 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_7)
                )
            }
            GAUGE_KEYHOLE_8 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_8)
                )
            }
            GAUGE_KEYHOLE_9 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_9)
                )
            }
            GAUGE_KEYHOLE_10 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_10)
                )
            }
            GAUGE_KEYHOLE_11 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_11)
                )
            }
            GAUGE_KEYHOLE_12 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_12)
                )
            }
            GAUGE_KEYHOLE_13 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_13)
                )
            }
            GAUGE_KEYHOLE_14 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_14)
                )
            }
            GAUGE_KEYHOLE_15 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_15)
                )
            }
            GAUGE_KEYHOLE_16 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_16)
                )
            }
            GAUGE_KEYHOLE_17 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_17)
                )
            }
            GAUGE_KEYHOLE_18 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_18)
                )
            }
            GAUGE_KEYHOLE_19 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_19)
                )
            }
            GAUGE_KEYHOLE_20 -> {
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_20)
                )
            }
            else ->{
                img_progress.setImageDrawable(
                    ContextCompat.getDrawable(context,R.drawable.gauge_keyhole_1)
                )
            }
        }
    }
    fun setGaugeBottomIcon(icon:Drawable?){
        val img_gaugebottomicon = findViewById<ImageView>(R.id.imageDecibelCPB)
        icon?.let {
            img_gaugebottomicon.setImageDrawable(it)
        }
    }
    fun setGaugeBottomIconColor(color: Int){
        val img_gaugebottomicon = findViewById<ImageView>(R.id.imageDecibelCPB)
        img_gaugebottomicon.setColorFilter(
            ContextCompat.getColor(context,color)
        )
    }
    fun prepareGauge(context: Context) {

        mRelativeLayoutGaugeCurrentDb = findViewById(R.id.relativeLayoutGaugeCurrentDb)
        imageViewNeedle = findViewById(R.id.imageViewNeedle)
        textViewCurrentDbCPB = findViewById(R.id.textViewCurrentDbCPB)
        textViewCPBLabels[0] = findViewById(R.id.textView0CPB)
        textViewCPBLabels[1] = findViewById(R.id.textView20CPB)
        textViewCPBLabels[2] = findViewById(R.id.textView30CPB)
        textViewCPBLabels[3] = findViewById(R.id.textView50CPB)
        textViewCPBLabels[4] = findViewById(R.id.textView60CPB)
        textViewCPBLabels[5] = findViewById(R.id.textView70CPB)
        textViewCPBLabels[6] = findViewById(R.id.textView90CPB)
        textViewCPBLabels[7] = findViewById(R.id.textView100CPB)
        textViewCPBLabels[8] = findViewById(R.id.textView120CPB)
        mCircleProgressBar = findViewById(R.id.my_cpb)
        mCircleProgressBarShadowHide = findViewById(R.id.my_cpb_shadow_hide)
        mCircleProgressBar.max = 165
        mCircleProgressBarShadowHide.max = 165
        mCircleProgressBar.setDrawBackgroundOutsideProgress(true)
        mCircleProgressBar.setProgressBackgroundColor(
            ContextCompat.getColor(
                context,
                R.color.colorBackground
            )
        )
        mCircleProgressBar.setProgressStartColor(
            ContextCompat.getColor(
                context,
                R.color.colorCircularProgressBarBackground
            )
        )
        mCircleProgressBar.setProgressEndColor(
            ContextCompat.getColor(
                context,
                R.color.colorCircularProgressBarBackground
            )
        )
        mCircleProgressBar.progress = 0

        mRelativeLayoutGaugeCurrentDb.visibility = INVISIBLE
        imageViewNeedle.visibility = INVISIBLE
        for (i in 0..8) {
            textViewCPBLabels[i]?.setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorBackground
                )
            )
        }
        val animatorGauge = ValueAnimator.ofInt(0, 121)
        animatorGauge.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            mCircleProgressBar.progress = progress
        }
        animatorGauge.addListener(object :Animator.AnimatorListener{
            override fun onAnimationCancel(p0: Animator) {

            }

            override fun onAnimationEnd(p0: Animator) {

            }

            override fun onAnimationRepeat(p0: Animator) {

            }

            override fun onAnimationStart(p0: Animator) {
                mGaugeListener?.onStartPreparing()
            }


        })
        animatorGauge.repeatCount = 0
        animatorGauge.duration = 1200
        animatorGauge.start()

        val animatorText = ValueAnimator.ofInt(0, 9)
        animatorText.addUpdateListener { animation ->
            val i = animation.animatedValue as Int
            if (i >= 0 && i < 9) textViewCPBLabels[i]?.setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorActiveGaugeText
                )
            )
            if (i > 0) textViewCPBLabels[i - 1]?.setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorNotActiveGaugeText
                )
            )
            if (i == 9) {
                imageViewNeedle.visibility = VISIBLE
                mRelativeLayoutGaugeCurrentDb.visibility = VISIBLE
                imageViewNeedle.rotation = 0f
                mCircleProgressBar.setDrawBackgroundOutsideProgress(true)
                mCircleProgressBar.setProgressBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorCircularProgressBarBackground
                    )
                )
                mCircleProgressBar.setProgressStartColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorTransparent
                    )
                )
                mCircleProgressBar.setProgressEndColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorTransparent
                    )
                )
                mCircleProgressBar.progress = 0
            }
        }
        animatorText.addListener(object :Animator.AnimatorListener{
            override fun onAnimationCancel(p0: Animator) {

            }

            override fun onAnimationEnd(p0: Animator) {
                mGaugeListener?.onGaugePrepared(true)
            }

            override fun onAnimationRepeat(p0: Animator) {

            }

            override fun onAnimationStart(p0: Animator) {

            }


        })
        animatorText.repeatCount = 0
        animatorText.duration = 800
        animatorText.startDelay = 1500
        animatorText.start()


    }

    fun setProgress(value: Float) {
        animatorValueOnGauge.cancel()
        val currentvalue = animatorValueOnGauge.getAnimatedValue() as Float
        if (value > currentvalue) {
            animatorValueOnGauge.setFloatValues(currentvalue, value)
            animatorValueOnGauge.start()
        } else {
            animatorValueOnGauge.setFloatValues(value, currentvalue)
            animatorValueOnGauge.reverse()
        }
    }

    companion object {
        val GAUGE_TEXT = "Speed"
        val DURATION = 2000
        val GAUGEBOTTOMICON_COLOR = Color.CYAN

        //progress background
        val GAUGE_KEYHOLE_1 = 1
        val GAUGE_KEYHOLE_2 = 2
        val GAUGE_KEYHOLE_3 = 3
        val GAUGE_KEYHOLE_4 = 4
        val GAUGE_KEYHOLE_5 = 5
        val GAUGE_KEYHOLE_6 = 6
        val GAUGE_KEYHOLE_7 = 7
        val GAUGE_KEYHOLE_8 = 8
        val GAUGE_KEYHOLE_9 = 9
        val GAUGE_KEYHOLE_10 = 10
        val GAUGE_KEYHOLE_11 = 11
        val GAUGE_KEYHOLE_12 = 12
        val GAUGE_KEYHOLE_13 = 13
        val GAUGE_KEYHOLE_14 = 14
        val GAUGE_KEYHOLE_15 = 15
        val GAUGE_KEYHOLE_16 = 16
        val GAUGE_KEYHOLE_17 = 17
        val GAUGE_KEYHOLE_18 = 18
        val GAUGE_KEYHOLE_19 = 19
        val GAUGE_KEYHOLE_20 = 20
    }

    fun addGaugeListener(listener:GaugeListener?){
        mGaugeListener = listener
    }
    interface GaugeListener{
        fun onProgress(progress:Float)
        fun onStartPreparing()
        fun onGaugePrepared(prepared:Boolean)
    }

    fun setMaxProgress(maxProgress:Float){
        val oldMax=textViewCPBLabelValues.last()
        this.maxProgress=maxProgress
        val rate=maxProgress/oldMax
        textViewCPBLabelValues.forEachIndexed { i, it ->
            textViewCPBLabelValues[i] = (rate * it).toInt()
            textViewCPBLabels[i]?.text = textViewCPBLabelValues[i].toString()
        }
    }
}