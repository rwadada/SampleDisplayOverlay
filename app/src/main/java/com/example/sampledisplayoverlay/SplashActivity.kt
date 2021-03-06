package com.example.sampledisplayoverlay

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val context:Context = this

        val view: View = findViewById(R.id.splash)

        val anim = AlphaAnimation(1f, 1f)
        anim.duration = 1000
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                // NOP
            }

            override fun onAnimationEnd(p0: Animation?) {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(0, 0)
                finish()
            }

            override fun onAnimationRepeat(p0: Animation?) {
                // NOP
            }
        })

        view.startAnimation(anim)
    }
}