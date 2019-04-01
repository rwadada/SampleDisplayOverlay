package com.example.sampledisplayoverlay

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val view: View by lazy {
        findViewById<View>(com.example.sampledisplayoverlay.R.id.splash)
    }
    val button1: Button by lazy {
        findViewById<Button>(R.id.button1)
    }
    val button2: Button by lazy {
        findViewById<Button>(R.id.button2)
    }
    val button3: Button by lazy {
        findViewById<Button>(R.id.button3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val anim = AlphaAnimation(1f, 0f)
        anim.duration = 2000
        anim.setAnimationListener(object : Animation.AnimationListener {
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

        button1.setOnClickListener {
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

    override fun onPause() {
        super.onPause()
        button1.visibility = View.GONE
        button2.visibility = View.GONE
        button3.visibility = View.GONE
        view.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        button1.visibility = View.VISIBLE
        button2.visibility = View.VISIBLE
        button3.visibility = View.VISIBLE
        view.visibility = View.GONE
    }

    private fun visibleAllButton(buttonList: List<Button>) {
        for (button in buttonList) {
            button.visibility = View.VISIBLE
        }
    }
}
