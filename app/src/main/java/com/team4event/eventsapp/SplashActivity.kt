package com.team4event.eventsapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.team4event.eventsapp.consts.SharedPreferenceKeys
import java.util.logging.Logger

class SplashActivity : AppCompatActivity() {
    private val logger = Logger.getLogger("SplashActivity")
    private lateinit var settings: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val settings = getSharedPreferences("PreferencesName", MODE_PRIVATE)
        val authKey = settings.getString(SharedPreferenceKeys.AUTH_KEY, "")

        if (authKey.isNullOrBlank()){
            logger.info("AuthActivity::class.java")
            startActivity(Intent(this@SplashActivity,AuthActivity::class.java))
        } else {
            logger.info("MainActivity::class.java")
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        }
    }
}