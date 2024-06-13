package com.example.buoi5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.buoi5.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private val binding by lazy { FragmentFirstBinding.inflate(layoutInflater) }

    private val mainActivity by lazy { activity as MainActivity }

    var fullName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
//            fullName = binding.edtFullName.text.toString()
//            binding.edtFullName.setText(mainActivity.fullName)
            mainActivity.fullName = binding.edtFullName.text.toString()
            Toast.makeText(requireContext(), "Click", Toast.LENGTH_SHORT).show()
        }
    }
}