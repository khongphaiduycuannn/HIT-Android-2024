package com.example.kiemtra1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kiemtra1.databinding.FragmentAllNoteBinding

class AllNoteFragment : Fragment() {

    private val binding by lazy { FragmentAllNoteBinding.inflate(layoutInflater) }

    private val noteAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rclAllNotes.layoutManager = LinearLayoutManager(requireContext())
        binding.rclAllNotes.adapter = noteAdapter

        noteAdapter.setNotesList(Data.notesList)
    }

    fun refreshNotesList() {
        noteAdapter.setNotesList(Data.notesList)
    }
}