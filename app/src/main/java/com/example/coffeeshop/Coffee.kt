package com.example.coffeeshop

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coffee(
    val id : Int,
    val name: String,
    val description: String,
    val image: Int,
    var price: Double,
    var count : Int,
    var size : String,
    var isFav : Boolean
): Parcelable
