package com.example.coffeeshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coffeeshop.databinding.FragmentFavBinding


class favFragment : Fragment() {
    private var _binding: FragmentFavBinding? = null
    private val binding get() = _binding!!
    private var coffeeList = ArrayList<Coffee>()
    private var favList = ArrayList<Coffee>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for(i in coffeeList){
            if(i.isFav){
                favList.add(i)
            }
        }

        binding.rvFav.adapter = CoffeeAdapter(favList)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}