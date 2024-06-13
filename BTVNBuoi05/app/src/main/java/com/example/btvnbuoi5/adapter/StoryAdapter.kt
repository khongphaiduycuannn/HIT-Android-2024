package com.example.btvnbuoi5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.btvnbuoi5.User
import com.example.btvnbuoi5.databinding.ItemStoryBinding

class StoryAdapter(
    private val storiesList: MutableList<User> = mutableListOf()
) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    class StoryViewHolder(val binding: ItemStoryBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context))
        return StoryViewHolder(binding)
    }

    override fun getItemCount(): Int = storiesList.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val ivStory = holder.binding.ivStory
        Glide.with(ivStory.context).load(storiesList[position].avatar).into(ivStory)
        holder.binding.ivUsername.text = storiesList[position].username
    }
}