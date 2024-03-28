package com.example.buoi4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buoi4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //    private lateinit var binding: ActivityMainBinding
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val list = mutableListOf(
        User("Minh Quân", "Sơn Đồng"),
        User("Khánh", "Sơn Đồng 1"),
        User("Vank", "Sơn Đồng 2"),
        User("Linh", "Sơn Đồng 3"),
        User("Đức", "Sơn Đồng 4"),
    )
    private val userAdapter = UserAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = userAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this)
//        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}