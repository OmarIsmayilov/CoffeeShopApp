package com.example.coffeeshop


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.databinding.CardItemBinding


class CoffeeAdapter(var coffeeList : ArrayList<Coffee>) : RecyclerView.Adapter<CoffeeAdapter.MyViewHolder>()  {

    inner class MyViewHolder(val binding : CardItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun setFilteredList(coffeeList: ArrayList<Coffee>){
        this.coffeeList = coffeeList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val design = CardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(design)
    }

    override fun getItemCount(): Int {
        return coffeeList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val coffee = coffeeList[position]
        holder.binding.coffee = coffee
        holder.binding.tvPrice.text = coffee.price.toString()
        holder.binding.ivCoffee.setImageResource(coffee.image)

        holder.binding.coffeeItem.setOnClickListener {

            Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragment2ToDetailFragment(coffee))
            coffeeList.clear()
        }

    }


}

