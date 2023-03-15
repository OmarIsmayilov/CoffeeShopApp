package com.example.coffeeshop

import android.app.AlertDialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.coffeeshop.databinding.FragmentDetailBinding
import kotlin.properties.Delegates


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val  binding get() = _binding!!
    private val args : DetailFragmentArgs by navArgs()
    private lateinit var coffee : Coffee
    private var price by Delegates.notNull<Double>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            _binding = FragmentDetailBinding.inflate(inflater,container,false)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cvS.setBackgroundResource(R.drawable.cv_selected)

        coffee = args.coffee
        price = coffee.price
        binding.tvName.text = coffee.name
        binding.tvDescription.text = coffee.description
        binding.ivCoffee.setImageResource(coffee.image)
        binding.ivCoffee.scaleType = ImageView.ScaleType.FIT_XY
        binding.cbFav.isChecked = coffee.isFav
        binding.cvS.setOnClickListener {
            setNormal()
            binding.cvS.setBackgroundResource(R.drawable.cv_selected)
            binding.tvS.setTextColor(Color.parseColor("#d27843"))
            coffee.size = "s"

        }
        binding.cvM.setOnClickListener {
            setNormal()
            binding.cvM.setBackgroundResource(R.drawable.cv_selected)
            binding.tvM.setTextColor(Color.parseColor("#d27843"))
            coffee.size = "m"

        }
        binding.cvL.setOnClickListener {
            setNormal()
            binding.cvL.setBackgroundResource(R.drawable.cv_selected)
            binding.tvL.setTextColor(Color.parseColor("#d27843"))
            coffee.size = "l"

        }
        binding.btnInc.setOnClickListener {
            coffee.count+=1
            binding.tvCount.text = coffee.count.toString()
        }
        binding.btnDec.setOnClickListener {
            if (coffee.count>1){
                coffee.count-=1
                binding.tvCount.text = coffee.count.toString()
            }

        }
        binding.buttonAdd.setOnClickListener {
            coffee.price = price
            calculatePrice(coffee.size)
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Check the information")
            builder.setMessage("Name : ${coffee.name}\n" +
                    "Size : ${coffee.size.toUpperCase()}\n" +
                    "Count : ${coffee.count}\n" +
                    "Price : %.2f".format(coffee.price))
            builder.setPositiveButton("Add") { dialog, which -> Toast.makeText(context,"Succesfully added to bag",Toast.LENGTH_SHORT).show() }
            builder.setNegativeButton("Cancel"){dialog,which->}
            val dialog = builder.create()
            dialog.show()
        }
        binding.cbFav.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked){
                Toast.makeText(context,"Added to fav list",Toast.LENGTH_SHORT).show()
                coffee.isFav = true
            }else{
                Toast.makeText(context,"Removed from fav list",Toast.LENGTH_SHORT).show()
                coffee.isFav = false
            }


        }


    }



    private fun calculatePrice(size : String) {
        when(size){
            "m"->{coffee.price *= 1.5}
            "l"->{coffee.price *= 2}
        }
        coffee.price *=coffee.count
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setNormal(){
        binding.cvM.setBackgroundResource(R.drawable.cv_normal)
        binding.cvS.setBackgroundResource(R.drawable.cv_normal)
        binding.cvL.setBackgroundResource(R.drawable.cv_normal)
        binding.tvS.setTextColor(Color.parseColor("#95FBFBFB"))
        binding.tvM.setTextColor(Color.parseColor("#95FBFBFB"))
        binding.tvL.setTextColor(Color.parseColor("#95FBFBFB"))

    }

}