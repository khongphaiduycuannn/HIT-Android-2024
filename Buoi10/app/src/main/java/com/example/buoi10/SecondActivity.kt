package com.example.buoi10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.buoi10.databinding.ActivitySecondBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class SecondActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    private val auth = Firebase.auth

    private val database = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnClearText.setOnClickListener {
            binding.edtUsername.clearText()
            binding.edtAddress.clearText()
            binding.edtAge.clearText()
        }

        binding.btnShowUserList.setOnClickListener {
//            database.collection("users")
//                .get()
//                .addOnSuccessListener { documents ->
//                    val userList = mutableListOf<User>()
//                    for (document in documents) {
//                        val user = document.toObject<User>()
//                        userList.add(user)
//                    }
//                    println(userList)
//                }
//                .addOnFailureListener {
//
//                }
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        binding.btnSave.setOnClickListener {
            auth.currentUser?.let { user ->
                val newUser = User(
                    username = binding.edtUsername.text.toString(),
                    address = binding.edtAddress.text.toString(),
                    age = binding.edtAge.text.toString().toInt()
                )

                database.collection("users")
                    .document(user.uid)
                    .set(newUser)
                    .addOnSuccessListener {
                        Toast.makeText(
                            this,
                            "Lưu thành công!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            this,
                            it.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
            }
        }

        auth.currentUser?.let { user ->
            database.collection("users")
                .document(user.uid)
                .get()
                .addOnSuccessListener { document ->
                    val user = document.toObject<User>()

                    binding.edtUsername.setText(user?.username.toString())
                    binding.edtAddress.setText(user?.address.toString())
                    binding.edtAge.setText(user?.age.toString())
                }
                .addOnFailureListener {
                    Toast.makeText(
                        this,
                        it.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
        }

        binding.btnLogOut.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }
    }
}