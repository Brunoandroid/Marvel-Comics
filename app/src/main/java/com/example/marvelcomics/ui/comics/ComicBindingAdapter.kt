package com.example.marvelcomics.ui.comics

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.marvelcomics.data.model.Price

class ComicBindingAdapter {

    companion object {

        @BindingAdapter("listPrice")
        @JvmStatic
        fun listPrice(textView: TextView, listPrice: List<Price>) {
            val price = listPrice[0].price
            textView.text = price.toString()
        }

    }

}