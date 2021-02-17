package com.example.marvelcomics.data.model


import com.google.gson.annotations.SerializedName

data class Comic(
        @SerializedName("description")
        val description: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("prices")
        val prices: List<Price>,
        @SerializedName("thumbnail")
        val thumbnail: Thumbnail,
        @SerializedName("title")
        val title: String
) {
        val extension: String get() = "/portrait_medium.jpg"
}