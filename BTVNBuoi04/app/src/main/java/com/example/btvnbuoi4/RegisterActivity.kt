package com.example.btvnbuoi4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.btvnbuoi4.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val fullName = binding.edtFullName.text.toString()
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()

            if (fullName.isBlank() || username.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin.", Toast.LENGTH_LONG).show()
            }
            else {
                var flag = true
                Data.usersList.forEach { user ->
                    if (user.username == username) {
                        Toast.makeText(this, "Tên tài khoản đã được sử dụng.", Toast.LENGTH_LONG).show()
                        flag = false
                    }
                }
                if (flag) {
                    val user = User(fullName, username, password)
                    Data.usersList.add(user)
                    startActivity(Intent(this, MainActivity::class.java))
                    finishAffinity()
                }
            }
        }
    }
}