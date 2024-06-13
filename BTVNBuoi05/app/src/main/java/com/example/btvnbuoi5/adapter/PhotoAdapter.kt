package com.example.btvnbuoi5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.btvnbuoi5.databinding.ItemPhotoBinding

class PhotoAdapter(
    private val photosList: MutableList<String> = mutableListOf()
) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context))
        return PhotoViewHolder(binding)
    }

    override fun getItemCount(): Int = photosList.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val ivPhoto = holder.binding.ivPhoto
        Glide.with(ivPhoto.context).load(photosList[position]).into(ivPhoto)
    }
}