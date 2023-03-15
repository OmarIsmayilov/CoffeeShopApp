package com.example.coffeeshop

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.fragment.findNavController

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
       window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        window.statusBarColor = Color.TRANSPARENT

        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        },3000)
    }
}