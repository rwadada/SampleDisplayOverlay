package com.example.sampledisplayoverlay

import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlagSecureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flagsecure)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)

        val textView: TextView = findViewById(R.id.description)
        val descriptionStr = """
            FLAG_SECUREを設定した場合、上部の画面のように
            現在表示されている画面が真っ黒になり
            タスクマネージャ上でも同様に表示される。
        """.trimIndent()

        textView.text = descriptionStr

        val backBtn: Button = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }
    }
}