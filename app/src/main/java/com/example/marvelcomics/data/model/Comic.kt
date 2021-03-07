package com.example.marvelcomics.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
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
) : Parcelable {
    val extension: String get() = "/portrait_medium.jpg"
}

