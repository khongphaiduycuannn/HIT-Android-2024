package com.example.buoi3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val content = intent.getStringExtra("key")
        val user: User? = intent.getParcelableExtra("user")

        val textView: TextView = findViewById(R.id.textView)
        if (user != null) {
            textView.text = user.username
        }
    }
}