package com.example.btvnbuoi5.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.btvnbuoi5.Data
import com.example.btvnbuoi5.adapter.PostAdapter
import com.example.btvnbuoi5.adapter.StoryAdapter
import com.example.btvnbuoi5.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rclListStories.adapter = StoryAdapter(Data.storiesList)
        binding.rclListStories.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.rclListPosts.adapter = PostAdapter(Data.postsList)
        binding.rclListPosts.layoutManager =
            LinearLayoutManager(requireContext())
    }
}