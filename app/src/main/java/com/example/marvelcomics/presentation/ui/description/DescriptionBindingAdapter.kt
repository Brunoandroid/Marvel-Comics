package com.example.marvelcomics.presentation.ui.description

import android.widget.TextView
import androidx.databinding.BindingAdapter

class DescriptionBindingAdapter {

    companion object {

        @BindingAdapter("priceComicsFull")
        @JvmStatic
        fun priceComicsFull(textView: TextView, priceComicFull: String) {
            textView.text = "R$ $priceComicFull"
        }

    }

}