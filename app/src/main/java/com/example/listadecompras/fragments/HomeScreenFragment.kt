package com.example.listadecompras.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.listadecompras.databinding.FragmentHomeScreenBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.listadecompras.R

class HomeScreenFragment: Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeScreenBinding.inflate(layoutInflater, container, false)
        val root = binding.root

        insertProductListner()

        return root
    }

    fun insertProductListner(){
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreenFragment_to_insertProductFragment)
        }
    }
}