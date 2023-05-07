package com.farimarwat.supergaugeview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.farimarwat.supergaugeview.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mygaugeview.addGaugeListener(object :SuperGaugeView.GaugeListener{
            override fun onProgress(progress: Float) {
//                Log.e("TEST","Gauge: ${progress}")
            }

            override fun onStartPreparing() {
                Log.e("TEST","Gauge preparing started")
            }

            override fun onGaugePrepared(prepared: Boolean) {
                if(prepared){
                    CoroutineScope(Dispatchers.Main).launch {
                      while(true){
                          delay(1000)
                          val progress = (0..121).random()
                          binding.mygaugeview.setProgress(progress.toFloat())
                      }
                    }
                }
            }

        })
        binding.mygaugeview.prepareGauge(this)
        binding.mygaugeview.setMaxProgress(240f)

    }
}