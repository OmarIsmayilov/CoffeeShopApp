package com.example.coffeeshop

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.databinding.NameItemBinding

class NameAdapter(var coffeeList : ArrayList<Coffee>) : RecyclerView.Adapter<NameAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding : NameItemBinding): RecyclerView.ViewHolder(binding.root)
    private var selectedName = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val design = NameItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(design)
    }

    override fun getItemCount(): Int {
        return coffeeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val coffee = coffeeList[position]
        holder.binding.tvNameItem.text = coffee.name

        holder.binding.tvNameItem.setOnClickListener {
            holder.binding.tvNameItem.setTextColor(Color.parseColor("#d27843"))
            selectedName = coffee.name
        }

    }




}