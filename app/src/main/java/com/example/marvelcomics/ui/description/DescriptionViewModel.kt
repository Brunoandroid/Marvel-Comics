package com.example.marvelcomics.ui.description

import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelcomics.data.model.Comic
import com.example.marvelcomics.data.model.Price
import java.math.RoundingMode
import java.text.DecimalFormat

class DescriptionViewModel : ViewModel() {

    private var number = 1

    private val _plots = MutableLiveData<String>()
    val plots: LiveData<String> get() = _plots

    private val _price = MutableLiveData<String>()
    val price: LiveData<String> get() = _price

    private val _count = MutableLiveData<String>()
    val count: LiveData<String> get() = _count

    init {
        _count.value = number.toString()
    }


        fun calculateInitPrice(listPrice: List<Price>) {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING

            val dolarToReal = 5.41
            val priceOriginal = ((listPrice[0].price) * dolarToReal)
            val pricePlotsOriginal = priceOriginal / 3

            val price = df.format(priceOriginal)
            val pricePlots = df.format(pricePlotsOriginal)

            _plots.value = "3x de R$ $pricePlots"
            _price.value = "R$ $price"


        }


    fun countLow() {
        _count.value = (--number).toString()
        Log.d("CountLow", number.toString())
    }

    fun countHigh() {
        _count.value = (++number).toString()
        Log.d("CountHigh", number.toString())
    }

}