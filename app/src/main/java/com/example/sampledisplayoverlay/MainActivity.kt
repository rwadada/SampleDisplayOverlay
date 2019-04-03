package com.example.sampledisplayoverlay

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val splash: View by lazy {
        findViewById<View>(R.id.splash)
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
        Log.d("debug", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.apply {
            setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, DefaultActivity::class.java)
                )
            }
            visibility = View.GONE
        }

        button2.apply {
            setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, FlagSecureActivity::class.java)
                )
            }
            visibility = View.GONE
        }

        button3.apply {
            setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, SplashOverlayActivity::class.java)
                )
            }
            visibility = View.GONE
        }

        splash.visibility = View.VISIBLE

    }

    override fun onStart() {
        Log.d("debug", "onStart")
        super.onStart()
        button1.visibility = View.GONE
        button2.visibility = View.GONE
        button3.visibility = View.GONE
        splash.visibility = View.VISIBLE
    }

    override fun onPause() {
        Log.d("debug", "onPause")
        super.onPause()
        button1.visibility = View.GONE
        button2.visibility = View.GONE
        button3.visibility = View.GONE
        splash.visibility = View.VISIBLE
    }

    override fun onStop() {
        Log.d("debug", "onStop")
        super.onStop()
        button1.visibility = View.GONE
        button2.visibility = View.GONE
        button3.visibility = View.GONE
        splash.visibility = View.VISIBLE
    }

    // /* この先頭の//を消すとOnResumeに関する部分が消える→これをすると常にsplash．onResumeがいるだけで，バックグラウンドに回ってもsplashにはならない．
    override fun onResume() {
        Log.d("debug", "onResume")
        super.onResume()
        button1.visibility = View.VISIBLE
        button2.visibility = View.VISIBLE
        button3.visibility = View.VISIBLE
        splash.visibility = View.GONE
    }
    // */

    private fun visibleAllButton(buttonList: List<Button>) {
        for (button in buttonList) {
            button.visibility = View.VISIBLE
        }
    }
}
