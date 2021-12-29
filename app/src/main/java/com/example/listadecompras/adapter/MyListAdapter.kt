package com.example.listadecompras.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecompras.R
import com.example.listadecompras.model.ProductEntity

class MyListAdapter: RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {

    var data = listOf<ProductEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.adapter_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources

        holder.productName.text = "${item.name}"
        holder.productQuantity.text = "${item.quantity.toString()}"
        holder.producValue.text = "R$${item.price.toString()}"
    }

    override fun getItemCount(): Int {
       return data.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val productName: TextView = itemView.findViewById(R.id.textName)
        val producValue: TextView = itemView.findViewById(R.id.textValue)
        val productQuantity: TextView = itemView.findViewById(R.id.textQuantity)
    }
}