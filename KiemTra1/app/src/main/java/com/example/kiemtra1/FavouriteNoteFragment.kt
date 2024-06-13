package com.example.kiemtra1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kiemtra1.databinding.FragmentFavouriteNoteBinding

class FavouriteNoteFragment : Fragment() {

    private val binding by lazy { FragmentFavouriteNoteBinding.inflate(layoutInflater) }

    private val noteAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rclFavouriteNotes.layoutManager = LinearLayoutManager(requireContext())
        binding.rclFavouriteNotes.adapter = noteAdapter

        noteAdapter.setNotesList(Data.notesList.filter {
            it.isFavourite
        } as MutableList<Note>)
    }

    fun refreshNotesList() {
        noteAdapter.setNotesList(Data.notesList)
    }
}