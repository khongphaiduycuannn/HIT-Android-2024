package com.example.btvnbuoi4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.btvnbuoi4.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    private val usersList = Data.usersList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()

            if (username.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Vui lòng nhập tài khoản và mật khẩu.", Toast.LENGTH_LONG)
                    .show()
            } else {
                var flag = true
                usersList.forEach { user ->
                    if (user.username == username && user.password == password) {
                        flag = false
                        startActivity(Intent(this, MainActivity::class.java))
                        finishAffinity()
                    }
                }
                if (flag) {
                    Toast.makeText(this, "Tài khoản hoặc mật khẩu không đúng.", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}