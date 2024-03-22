package com.example.buoi3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*  Bien
            // Int: So nguyen
            // Double: Số thực
            // String: Chuỗi

            var bien1: Int = 5
            val bien2: Double = 5.0
            val bien3 = 5
            val bien4 = 5.0

            val list: List<Int> = listOf(
                5, 6, 7, 8, 9
            )
            println(list)

            val list1: MutableList<Int> = mutableListOf(
                5, 6, 7, 8, 9
            )
            list1[2] = 5
            println(list1)
        */

        val button: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editText)

        button.setOnClickListener {
            println("Vua duoc an!!")
//            Toast.makeText(this, "Đây là cái toast", Toast.LENGTH_SHORT).show()

            val content = editText.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("key", content)

            val user = User("Nguyễn Duy Minh Quân", true)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }

    fun ham1(bien1: Int, bien2: Int): Int {
        return bien1 + bien2
    }
//
//    override fun onStart() {
//        super.onStart()
//        println("On start")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        println("On resume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        println("On pause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        println("On stop")
//    }
}