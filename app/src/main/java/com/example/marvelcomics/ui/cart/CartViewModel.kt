package com.example.marvelcomics.ui.cart

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.marvelcomics.repository.Repository

class CartViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    fun getCart() = repository.cartComicRepository.getCart()

}