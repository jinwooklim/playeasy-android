package com.prography.playeasy.landing.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.prography.playeasy.R
import com.prography.playeasy.main.activity.BeforeLoginMain
import com.prography.playeasy.util.UIHelper

class Landing : AppCompatActivity() {
    val DELAY_MILLIS: Long = 2500
    val handler: Handler = Handler()

    var run = Runnable {
        val intent = Intent(applicationContext, BeforeLoginMain::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        UIHelper.hideWindow(this)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(run, DELAY_MILLIS)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(run)
    }
}