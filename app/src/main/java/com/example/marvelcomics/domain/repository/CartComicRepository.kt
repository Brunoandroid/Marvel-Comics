package com.example.marvelcomics.domain.repository

import com.example.marvelcomics.data.model.Comic

interface CartComicRepository {

    suspend fun addCart(comic: Comic, price: Double, priceUnity: String, amount: String)

    fun getCart()

    suspend fun checkComic(comic: Comic)

    suspend fun removeFromComic(comic: Comic)

    suspend fun updateFromComic(comic: Comic, price: Double, priceUnity: String, amount: String)

}