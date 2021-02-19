package com.example.marvelcomics.data.db.cart

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marvelcomics.data.model.Comic

@Dao
interface CartDao {

    @Insert
    suspend fun addCart(cartComics: CartComics)

    @Query("SELECT * FROM cart_comics")
    fun getCart(): LiveData<List<CartComics>>

    @Query("SELECT count(*) FROM cart_comics WHERE cart_comics.comic = :comic")
    suspend fun checkComic(comic: Comic): Int

    @Query("DELETE FROM cart_comics WHERE cart_comics.comic = :comic")
    suspend fun removeFromComic(comic: Comic) : Int

    @Query("UPDATE cart_comics set comic = :comic, price = :price, plots = :plots, amount = :amount WHERE cart_comics.comic = :comic")
    suspend fun updateFromComic(comic: Comic, price: String, plots: String, amount: Int) : Int

}