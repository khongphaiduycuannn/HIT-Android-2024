package com.example.kiemtra1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kiemtra1.databinding.ItemNoteBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var notesList = mutableListOf<Note>()

    class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = notesList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notesList[position]
        with(holder) {
            binding.tvTitle.text = note.title
            binding.tvContent.text = note.content
            binding.tvCreated.text = "Created at: ${note.createdAt}"
            binding.cbIsFavourite.isChecked = note.isFavourite

            binding.cbIsFavourite.setOnClickListener {
                note.isFavourite = binding.cbIsFavourite.isChecked
                Data.notesList[position].isFavourite = note.isFavourite
            }
        }
    }

    fun setNotesList(notesList: MutableList<Note>) {
        this.notesList = notesList
        notifyDataSetChanged()
    }
}