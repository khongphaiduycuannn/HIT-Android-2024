package com.example.btvnbuoi5.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.btvnbuoi5.Data
import com.example.btvnbuoi5.R
import com.example.btvnbuoi5.adapter.PhotoAdapter
import com.example.btvnbuoi5.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val binding by lazy { FragmentProfileBinding.inflate(layoutInflater) }

    private val photoAdapter = PhotoAdapter(
        Data.photosList
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rclListPhotos.adapter = photoAdapter
        binding.rclListPhotos.layoutManager = GridLayoutManager(requireContext(), 3)

        Glide.with(requireContext()).load(R.drawable.img_str1).into(binding.ivStory1)
        Glide.with(requireContext()).load(R.drawable.img_str2).into(binding.ivStory2)
        Glide.with(requireContext()).load(R.drawable.img_str3).into(binding.ivStory3)
    }
}