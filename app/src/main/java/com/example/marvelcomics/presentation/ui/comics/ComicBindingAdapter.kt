package com.example.marvelcomics.presentation.ui.comics

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.marvelcomics.data.model.Comic
import com.example.marvelcomics.data.model.Price
import java.math.RoundingMode
import java.text.DecimalFormat

class ComicBindingAdapter {

    companion object {

        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(imageView: ImageView, comic: Comic) {
            var imageUrl = comic.thumbnail.path + comic.extension
            Glide.with(imageView)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
        }

        @BindingAdapter("listPrice")
        @JvmStatic
        fun listPrice(textView: TextView, listPrice: List<Price>) {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING

            val dolarConvert = 5.41
            val priceOriginal = ((listPrice[0].price) * dolarConvert)
            val price = df.format(priceOriginal)

            textView.text = "R$ $price"
        }

    }

}