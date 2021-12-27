package com.example.listadecompras.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecompras.R
import com.example.listadecompras.model.ProductEntity

class MyListAdapter: RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.fragment_add_product, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val productName: EditText = view.findViewById(R.id.editName)
        val producPrice: EditText = view.findViewById(R.id.editPrice)
        val productQuantity: EditText = view.findViewById(R.id.editQuantity)
    }
}