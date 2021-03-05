package com.example.marvelcomics.presentation.ui.description

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.data.model.Comic
import com.example.marvelcomics.data.model.Price
import com.example.marvelcomics.data.repository.CartComicRepository
import kotlinx.coroutines.launch
import java.math.RoundingMode
import java.text.DecimalFormat

class DescriptionViewModel @ViewModelInject constructor(
    private var cartComicRepository: CartComicRepository
) : ViewModel() {

    private var number = 1
    private var fullPrice = 0.0

    private var priceOriginal = 0.0
    private var pricePlotsOriginal = 0.0

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
        priceOriginal = ((listPrice[0].price) * dolarToReal)
        fullPrice = priceOriginal
        pricePlotsOriginal = priceOriginal / 3

        val pricePlotsComic = df.format(pricePlotsOriginal)
        val priceComic = df.format(priceOriginal)

        _plots.value = "3x de R$ $pricePlotsComic"
        _price.value = "$priceComic"


    }

    fun countLow() {
        --number
        calculateUpdatePrice()
    }

    fun countHigh() {
        ++number
        calculateUpdatePrice()
    }

    fun calculateUpdatePrice() {
        if (this.number > 0) {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING

            val updatePriceOriginal = priceOriginal * number
            fullPrice = updatePriceOriginal
            val updatePricePlots = updatePriceOriginal / 3

            val priceComic = df.format(updatePriceOriginal)
            val pricePlots = df.format(updatePricePlots)


            _price.value = "$priceComic"
            _plots.value = "3x de $pricePlots"

            _count.value = (number).toString()
        } else if (number <= 0) {
            number++
        }
    }

    fun addCart(comic: Comic) {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        val priceOriginalCompress = df.format(priceOriginal)
        viewModelScope.launch {
            cartComicRepository.addCart(
                comic, fullPrice,
                priceOriginalCompress.toString(), "Quantidade " + number.toString()
            )
        }
    }

    suspend fun checkComic(comic: Comic) = cartComicRepository.checkComic(comic)

    fun updateFromComic(comic: Comic) {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        val priceOriginalCompress = df.format(priceOriginal)
        viewModelScope.launch {
            cartComicRepository.updateFromComic(
                comic, fullPrice,
                priceOriginalCompress, "Quantidade " + number.toString()
            )
        }
    }
}