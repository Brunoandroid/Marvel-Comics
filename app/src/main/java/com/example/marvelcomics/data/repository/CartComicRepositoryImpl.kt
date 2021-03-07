package com.example.marvelcomics.data.repository

import com.example.marvelcomics.data.db.cart.CartComics
import com.example.marvelcomics.data.db.cart.CartDao
import com.example.marvelcomics.data.model.Comic
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class CartComicRepositoryImpl @Inject constructor(
    private var cartDao: CartDao
) {

    suspend fun addCart(comic: Comic, price: Double, priceUnity: String, amount: String) =
         cartDao.addCart(CartComics(comic, price, priceUnity, amount))

     fun getCart() = cartDao.getCart()

     suspend fun checkComic(comic: Comic) = cartDao.checkComic(comic)

     suspend fun removeFromComic(comic: Comic) {
         cartDao.removeFromComic(comic)
     }

     suspend fun updateFromComic(comic: Comic, price: Double, priceUnity: String, amount: String) {
         cartDao.updateFromComic(comic, price, priceUnity, amount)
     }

}