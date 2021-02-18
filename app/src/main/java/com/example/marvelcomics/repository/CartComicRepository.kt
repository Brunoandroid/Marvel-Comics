package com.example.marvelcomics.repository

import com.example.marvelcomics.data.db.cart.CartComics
import com.example.marvelcomics.data.db.cart.CartDao
import com.example.marvelcomics.data.model.Comic
import javax.inject.Inject

class CartComicRepository @Inject constructor(
    private var cartDao: CartDao
) {
    suspend fun addCart(comic: Comic, price: String, plots: String) = cartDao.addCart(CartComics(comic, price, plots))

    fun getCart() = cartDao.getCart()

    suspend fun checkComic(comic: Comic) = cartDao.checkComic(comic)

    suspend fun removeFromComic(comic: Comic){
        cartDao.removeFromComic(comic)
    }

    suspend fun updateFromComic(comic: Comic, price: String, plots: String){
        cartDao.updateFromComic(comic, price, plots)
    }

}