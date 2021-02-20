package com.example.marvelcomics.ui.cart

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.marvelcomics.data.db.cart.CartComics

class CartBidingAdapter {

    companion object {

        @BindingAdapter("loadTextPriceUnity")
        @JvmStatic
        fun loadTextPriceUnity(textView: TextView, textPriceUnity: String) {
            textView.text = "1 Unidade: R$" + textPriceUnity
        }

    }

}