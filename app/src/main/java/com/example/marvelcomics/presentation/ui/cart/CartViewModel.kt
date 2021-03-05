package com.example.marvelcomics.presentation.ui.cart

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.marvelcomics.data.repository.CartComicRepositoryImpl

class CartViewModel @ViewModelInject constructor(
    private val cartComicRepositoryImpl: CartComicRepositoryImpl
) : ViewModel() {

    fun getCart() = cartComicRepositoryImpl.getCart()

}