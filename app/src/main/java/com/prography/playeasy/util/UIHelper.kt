package com.prography.playeasy.util

import android.content.Intent
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.prography.playeasy.R
import com.prography.playeasy.main.activity.Main


class UIHelper {
    companion object {
        @JvmStatic fun toolBarInitialize(activity: AppCompatActivity, view: View) {
            val toolBar = view as Toolbar
            activity.setSupportActionBar(toolBar)
            activity.actionBar?.setDisplayHomeAsUpEnabled(true)
            activity.actionBar?.setDisplayShowTitleEnabled(false)
        }

        @JvmStatic fun hideWindow(activity: AppCompatActivity) {
            activity.window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        @JvmStatic fun bottomNavigationInitialize(activity: AppCompatActivity, view: View) {
            val bottomNavigationView = view as BottomNavigationView
            val context = activity.applicationContext
            var cls: Class<*>? = null
            bottomNavigationView.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.homeNavigatation -> {
                        cls = Main::class.java
                    }
                }
                true
            }

            val intent = Intent(context, cls)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.startActivity(intent)
        }
    }
}