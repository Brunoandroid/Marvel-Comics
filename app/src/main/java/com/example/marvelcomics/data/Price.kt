package com.example.marvelcomics.data


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("price")
    val price: Int,
    @SerializedName("type")
    val type: String
)