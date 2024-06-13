package com.example.btvnbuoi5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.btvnbuoi5.Post
import com.example.btvnbuoi5.databinding.ItemPostBinding

class PostAdapter(
    private val postsList: MutableList<Post> = mutableListOf()
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context))
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = postsList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        with(holder) {
            val post = postsList[position]

            val ivAvatar = binding.ivAvatar
            val ivContent = binding.ivContent
            Glide.with(ivAvatar.context).load(post.user.avatar).into(ivAvatar)
            Glide.with(ivContent.context).load(post.content).into(ivContent)

            binding.tvUsername.text = post.user.username
            binding.tvLocate.text = post.locate
            binding.tvLikeCount.text = "${post.favouriteCount} people"
        }
    }
}