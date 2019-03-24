package com.example.sampledisplayoverlay

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val view: View = findViewById(R.id.splash)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)

        val anim = AlphaAnimation(1f, 0f)
        anim.duration = 2000
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                // NOP
            }

            override fun onAnimationEnd(p0: Animation?) {
                view.visibility = View.GONE
                val buttonList = listOf(button1, button2, button3)
                visibleAllButton(buttonList)

            }

            override fun onAnimationRepeat(p0: Animation?) {
                // NOP
            }
        })

        view.startAnimation(anim)

        button1.setOnClickListener{
            startActivity(
                Intent(this, DefaultActivity::class.java)
            )
        }

        button2.setOnClickListener {
            startActivity(
                Intent(this, FlagSecureActivity::class.java)
            )
        }

        button3.setOnClickListener {
            startActivity(
                Intent(this, SplashOverlayActivity::class.java)
            )
        }
    }

    private fun visibleAllButton(buttonList: List<Button>) {
        for (button in buttonList) {
            button.visibility = View.VISIBLE
        }
    }
}
