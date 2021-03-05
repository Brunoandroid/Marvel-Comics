package com.example.marvelcomics.presentation.ui.cart

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.marvelcomics.data.repository.CartComicRepository

class CartViewModel @ViewModelInject constructor(
    private val cartComicRepository: CartComicRepository
) : ViewModel() {

    fun getCart() = cartComicRepository.getCart()

}