package com.example.marvelcomics.domain

import com.example.marvelcomics.data.model.Comic
import com.example.marvelcomics.data.model.Price
import com.example.marvelcomics.data.model.Thumbnail

object ComicsFactory {

    val listPrice = listOf(
        Price(9.99, "printPrice"),
        Price(3.99, "printPrice"),
    )

    val thumbnail = Thumbnail(
            "jpg",
            "http://i.annihil.us/u/prod/marvel/i/mg/2/f0/4bc6670c80007"
    )


    val comics = listOf(
        Comic(
            "comic",
            1,
            listPrice,
            thumbnail,
            "Official Handbook of the Marvel Universe (2004) #10 (MARVEL KNIGHTS)"
        ),
        Comic(
            "comic description",
            2,
            listPrice,
            thumbnail,
            "Official Comic"
        )
    )

}