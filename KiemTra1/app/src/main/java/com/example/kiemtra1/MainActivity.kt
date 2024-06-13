package com.example.kiemtra1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.kiemtra1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val allNoteFragment = AllNoteFragment()
    private val favouriteNoteFragment = FavouriteNoteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(binding.fragmentContainerView.id, allNoteFragment)
        }

        binding.btnCreateNote.setOnClickListener {
            startActivity(Intent(this, CreateNoteActivity::class.java))
        }

        binding.btnAllNote.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainerView.id, allNoteFragment)
            }
        }

        binding.btnFavourite.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainerView.id, favouriteNoteFragment)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        allNoteFragment.refreshNotesList()
        favouriteNoteFragment.refreshNotesList()
    }
}