package com.example.marvelcomics.ui.description

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.marvelcomics.data.model.Comic
import com.example.marvelcomics.data.model.Price
import java.math.RoundingMode
import java.text.DecimalFormat

class DescriptionBindingAdapter {

    companion object {

        @BindingAdapter("listPricePlots")
        @JvmStatic
        fun plots(textView: TextView, listPrice: List<Price>) {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING

            val dolarConvert = 5.41 / 3
            val priceOriginal = ((listPrice[0].price) * dolarConvert)
            val pricePlots = df.format(priceOriginal)

            textView.text = "3x de R$ $pricePlots"
        }

    }
}