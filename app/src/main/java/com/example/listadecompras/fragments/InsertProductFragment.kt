package com.example.listadecompras.fragments

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
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

        setHasOptionsMenu(true)

        binding = FragmentAddProductBinding.inflate(layoutInflater, container, false)
        val root = binding.root

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object: MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId){
                    R.id.add_confirme -> {
                        buttonCheckListner()
                        buttonCheckNavigateTo()
                        true
                    }
                    else -> onOptionsItemSelected(menuItem)
                }
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return root
    }

    fun buttonCheckListner(){
        viewModel.addNewProduct(binding.editName.text.toString(), binding.editPrice.text.toString(), binding.editQuantity.text.toString())
    }

    fun buttonCheckNavigateTo(){
        findNavController().navigate(R.id.action_insertProductFragment_to_homeScreenFragment)
    }
}