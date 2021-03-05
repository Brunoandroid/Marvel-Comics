package com.example.marvelcomics.presentation.ui.cart

import android.widget.TextView
import androidx.databinding.BindingAdapter

class CartBidingAdapter {

    companion object {

        @BindingAdapter("loadTextPriceUnity")
        @JvmStatic
        fun loadTextPriceUnity(textView: TextView, textPriceUnity: String) {
            textView.text = "1 Unidade: R$" + textPriceUnity
        }

    }

}