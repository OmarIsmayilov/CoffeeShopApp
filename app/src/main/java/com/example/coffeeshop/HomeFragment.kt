package com.example.coffeeshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.navigation.fragment.navArgs
import com.example.coffeeshop.Coffee
import com.example.coffeeshop.CoffeeAdapter
import com.example.coffeeshop.NameAdapter
import com.example.coffeeshop.R
import com.example.coffeeshop.databinding.FragmentHomeBinding
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private  var coffeeList = ArrayList<Coffee>()
    private val args: HomeFragmentArgs by navArgs()
    private lateinit var searchView : SearchView
    private lateinit var adapter: CoffeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = args.name
        searchView = binding.etSearch


        binding.rvName.adapter = NameAdapter(coffeeList)
        addToList()
        adapter = CoffeeAdapter(coffeeList)
        binding.rv.adapter = adapter
        binding.textView.setText("${name.capitalize()}, find the best\ncoffee for you")
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }


        })



    }

    private fun filterList(query:String?){
        if (query != null){
            val filteredList = ArrayList<Coffee>()
            for(i in coffeeList){
                if(i.name.toLowerCase(Locale.ROOT).contains(query)){
                 filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()){
                Toast.makeText(context,"No data found",Toast.LENGTH_LONG).show()
            }else{
                adapter.setFilteredList(filteredList)
            }

        }
    }

    private fun addToList() {
        coffeeList.add(
            Coffee(
                1,
                "Cappuccino",
                "Cappuccino is another popular espresso-based drink that is made with equal parts espresso, steamed milk, and milk foam. It is often served in a small cup and can be garnished with cocoa powder or cinnamon.",
                R.drawable.coffeesample,
                4.30,
                1,
                "s",
                false
            )
        )
        coffeeList.add(
            Coffee(
                2,
                "Latte",
                "A latte is a type of espresso-based drink that typically consists of a shot of espresso, steamed milk, and a thin layer of foam on top. It is often served in a tall glass and can be flavored with syrups such as vanilla, caramel, or hazelnut.",
                R.drawable.latte,
                4.6,
                1,
                "s",
                false
            )
        )
        coffeeList.add(
            Coffee(
                3,
                "Americano",
                "An Americano is a popular espresso-based drink that is made by adding hot water to a shot of espresso. It is similar to a regular brewed coffee, but with a stronger and bolder flavor.",
                R.drawable.americano,
                5.2,
                1,
                "s",
                false
            )
        )
        coffeeList.add(
            Coffee(
                4,
                "Espresso",
                "Espresso is a concentrated shot of coffee that is made by forcing hot water through finely ground coffee beans. It is a popular base for many coffee drinks and can be enjoyed on its own for a strong and intense coffee flavor.",
                R.drawable.espresso,
                4.40,
                1,
                "s",
                false
            )
        )
        coffeeList.add(
            Coffee(
                5,
                "Iced Coffee",
                "Iced coffee is a refreshing coffee drink that is served cold and often contains ice cubes. It is made by brewing coffee using hot water and then cooling it down before serving. It can be enjoyed plain or with cream, sugar, or flavored syrups.",
                R.drawable.icedcoffee,
                2.30,
                1,
                "s",
                false
            )
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}