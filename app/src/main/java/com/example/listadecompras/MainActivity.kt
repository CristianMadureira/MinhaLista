package com.example.listadecompras

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.listadecompras.databinding.ActivityMainBinding
import com.example.listadecompras.fragments.InsertProductFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    //    binding.fabAdd.setOnClickListener {
        //       val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)  as NavHostFragment
        //       val navController = navHostFragment.navController
        //      navController.navigate(R.id.action_mainActivity_to_insertProductFragment)
        // }
    }
       // setAddButtonListner()
    }

    fun setAddButtonListner(){

}