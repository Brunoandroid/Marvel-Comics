package com.example.marvelcomics.domain.model

import com.example.marvelcomics.data.model.Price
import com.example.marvelcomics.data.model.Thumbnail

data class ComicDomain(
    val description: String,
    val id: Int,
    val prices: List<Price>,
    val thumbnail: Thumbnail,
    val title: String
    )
