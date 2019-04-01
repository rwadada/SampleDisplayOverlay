package com.example.sampledisplayoverlay

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashOverlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashoverlay)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val textView: TextView = findViewById(R.id.description)
        val descriptionStr = """
            splash画面を被せた場合は、
            上の画像のようになる。
            onUserLeaveHintでsplash画面を被せ
            onRestartでsplash画面を除去する
            と行った操作を行っている。
        """.trimIndent()

        textView.text = descriptionStr

        val backBtn: Button = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }
    }

    override fun onStop() {
        val splash: View = findViewById(R.id.splash)
        splash.visibility = View.VISIBLE

        val backBtn: Button = findViewById(R.id.back_btn)
        backBtn.visibility = View.INVISIBLE
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
        val view: View = findViewById(R.id.splash)
        val backBtn: Button = findViewById(R.id.back_btn)

        val anim = AlphaAnimation(1f, 0f)
        anim.duration = 500
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                // NOP
            }

            override fun onAnimationEnd(p0: Animation?) {
                backBtn.visibility = View.VISIBLE
                view.visibility = View.GONE

            }

            override fun onAnimationRepeat(p0: Animation?) {
                // NOP
            }
        })

        view.startAnimation(anim)
    }
}