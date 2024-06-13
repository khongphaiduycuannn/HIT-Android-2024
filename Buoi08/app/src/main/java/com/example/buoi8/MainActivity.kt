package com.example.buoi8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.buoi8.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val noteRoomDatabase by lazy { NoteRoomDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val note = Note(
                title = binding.edtTitle.text.toString(),
                content = binding.edtContent.text.toString()
            )

            CoroutineScope(Dispatchers.IO).launch {
                noteRoomDatabase.noteDao().addNote(note)
            }
        }

        binding.btnShow.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                println(noteRoomDatabase.noteDao().getAllNote())
            }
        }
    }
}