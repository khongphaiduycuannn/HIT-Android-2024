package com.example.buoi12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.buoi12.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }

    private val viewModel by lazy {
        ViewModelProvider(this)[ListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        viewModel.result.observe(viewLifecycleOwner) { value ->
            binding.edtHehe.setText("$value")
        }

        binding.btnPlus.setOnClickListener {
            viewModel.plus()
        }
    }
}