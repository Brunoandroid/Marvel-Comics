package com.example.marvelcomics.data.model


import com.google.gson.annotations.SerializedName

data class Data(
        @SerializedName("count")
    val count: Int,
        @SerializedName("results")
    val results: List<Result>,
)