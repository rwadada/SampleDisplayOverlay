package com.example.sampledisplayoverlay

import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DefaultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val textView: TextView = findViewById(R.id.description)
        val descriptionStr = """
            デフォルト設定では上部の画面のように
            現在表示されている画面が
            タスクマネージャ上でも同様に表示される。
        """.trimIndent()

        textView.text = descriptionStr

        val backBtn: Button = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }
    }
}