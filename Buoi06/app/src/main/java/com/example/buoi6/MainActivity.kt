package com.example.buoi6

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buoi6.databinding.ActivityMainBinding
import com.example.buoi6.databinding.DialogViewBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val alertDialog = AlertDialog.Builder(this)
        alertDialog
            .setTitle("Đây là title!")
            .setMessage("Đây là message!")
            .setView(R.layout.dialog_view)
            .setPositiveButton("Positive") { _, _ ->
                Toast.makeText(this, "Positive", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Negative") { _, _ ->
                Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("Neutral") { _, _ ->
                Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show()
            }

        val dialog = Dialog(this)
        val dialogBinding = DialogViewBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialogBinding.btnSend.setOnClickListener {
            binding.tvIn4.text = dialogBinding.edtFullName.text.toString() + dialogBinding.edtAddress.text.toString()
            dialog.dismiss()
        }

        binding.btnShowDialog.setOnClickListener {
//            alertDialog.show()
            dialog.show()
        }
    }
}