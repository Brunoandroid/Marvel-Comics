package com.example.marvelcomics.data.service

import com.example.marvelcomics.data.model.ComicResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestApi {

    @GET("v1/public/comics")
    suspend fun getComics(
        @Query("limit") limit: Int
    ): Response<ComicResponse>?

}