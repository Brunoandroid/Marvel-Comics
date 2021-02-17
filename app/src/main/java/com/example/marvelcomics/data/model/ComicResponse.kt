package com.example.marvelcomics.data.model


import com.google.gson.annotations.SerializedName

data class ComicResponse(
        @SerializedName("data")
        val data: Data,
)