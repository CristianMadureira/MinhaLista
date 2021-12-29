package com.example.listadecompras.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.listadecompras.databinding.FragmentHomeScreenBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadecompras.R
import com.example.listadecompras.adapter.MyListAdapter
import com.example.listadecompras.model.MyListViewModel
import com.example.listadecompras.model.MyListViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.ext.scope

class HomeScreenFragment: Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding

    private val adapter:  MyListAdapter = MyListAdapter()

    private val viewModel: MyListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Infla fragmento utilizando DataBinding
        binding = FragmentHomeScreenBinding.inflate(layoutInflater, container, false)
        val root = binding.root

        //Configura RecyclerView
        binding.rcProducts.layoutManager = LinearLayoutManager(context)
        binding.rcProducts.adapter = adapter
        binding.rcProducts.setHasFixedSize(true)

        insertProductListner()
        observeProducts()

        return root
    }


    fun insertProductListner(){
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreenFragment_to_insertProductFragment)
        }
    }

    fun observeProducts(){
        lifecycleScope.launch {
            viewModel.flow.collect {
                adapter.data = it
            }
        }
    }
}