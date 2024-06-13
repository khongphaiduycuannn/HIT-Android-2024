package com.example.kiemtra1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kiemtra1.databinding.ActivityCreateNoteBinding
import java.util.Date

class CreateNoteActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCreateNoteBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnSaveNote.setOnClickListener {
            val title = binding.edtTitle.text.toString()
            val content = binding.edtContent.text.toString()

            if (title.isNotBlank() && content.isNotBlank()) {
                Data.notesList.add(
                    Note(
                        title,
                        content,
                        Date(),
                        false
                    )
                )
                Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Title must not be blank!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}