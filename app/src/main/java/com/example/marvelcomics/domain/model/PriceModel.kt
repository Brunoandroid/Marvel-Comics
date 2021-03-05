package com.example.marvelcomics.domain.model

import java.io.Serializable

data class PriceModel(
    val price: Double,
    val type: String
    ) : Serializable
