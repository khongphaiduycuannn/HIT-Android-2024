package com.example.buoi12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi12.databinding.ItemNoteBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var noteList = mutableListOf<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        with(holder) {
            binding.tvTitle.text = noteList[position].title
            binding.tvCreatedOn.text = "Created on: ${noteList[position].createdOn}"
            binding.tvContent.text = noteList[position].content
        }
    }

    fun setNoteList(newList: MutableList<Note>) {
        noteList = newList
        notifyDataSetChanged()
    }

    class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)
}