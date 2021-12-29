package com.example.listadecompras.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.listadecompras.R
import com.example.listadecompras.databinding.FragmentAddProductBinding
import com.example.listadecompras.model.MyListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class InsertProductFragment: Fragment() {

    private lateinit var binding: FragmentAddProductBinding

    private val viewModel: MyListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddProductBinding.inflate(layoutInflater, container, false)
        val root = binding.root

        buttonConfirmeListner()

        return root
    }

    fun buttonConfirmeListner(){
        binding.buttonConfirme.setOnClickListener{
            viewModel.addNewProduct(binding.editName.text.toString(), binding.editPrice.text.toString(), binding.editQuantity.text.toString())
        }

    }

}