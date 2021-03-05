package com.example.marvelcomics.presentation.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcomics.data.db.cart.CartComics
import com.example.marvelcomics.databinding.RowItemCartBinding

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    var list: List<CartComics> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding =
            RowItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartAdapter.CartViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class CartViewHolder(private val binding: RowItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cartComic: CartComics) {
            binding.cartComic = cartComic
        }

    }

    override fun getItemCount(): Int = list.size

    fun setListCartComics(listCartComics: List<CartComics>) {
        this.list = listCartComics
        notifyDataSetChanged()
    }

}