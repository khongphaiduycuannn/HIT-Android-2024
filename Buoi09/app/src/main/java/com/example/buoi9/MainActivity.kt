package com.example.buoi9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.buoi9.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        binding.recyclerView.layoutManager = LinearLayoutManager(this)

//        val apiService = RetrofitClient.getInstance().create(ApiService::class.java)
//        apiService.getAllStudents().enqueue(object : Callback<List<Student>> {
//            override fun onResponse(call: Call<List<Student>>, response: Response<List<Student>>) {
//                if (response.isSuccessful) {
//                    binding.recyclerView.adapter = response.body()?.let { StudentAdapter(it) }
//                } else {
//
//                }
//            }
//
//            override fun onFailure(call: Call<List<Student>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "Lỗi rồi", Toast.LENGTH_LONG).show()
//            }
//        })

        val apiService = RetrofitClient.getInstance().create(ApiService::class.java)
        binding.btnFind.setOnClickListener {
            val id = binding.edtStudentId.text.toString()
            apiService.getStudentById(id).enqueue(object : Callback<Student> {
                override fun onResponse(call: Call<Student>, response: Response<Student>) {
                    if (response.isSuccessful) {
                        val student = response.body()
                        with(binding) {
                            tvId.text = student?.id
                            tvName.text = student?.name
                            tvAge.text = student?.age.toString()
                            tvAddress.text = student?.address
                        }
                    } else {
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onFailure(call: Call<Student>, t: Throwable) {

                }
            })
        }

        binding.btnCreate.setOnClickListener {
            val student = Student(
                id = "Hehe",
                name = "Nhật",
                address = "Hoài Đức",
                age = 17
            )
            apiService.createStudent(student).enqueue(object : Callback<Student> {
                override fun onResponse(call: Call<Student>, response: Response<Student>) {
                    Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG)
                        .show()
                }

                override fun onFailure(call: Call<Student>, t: Throwable) {

                }
            })
        }
    }
}