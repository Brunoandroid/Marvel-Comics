package com.example.marvelcomics.domain.repository

import com.example.marvelcomics.data.model.ComicResponse
import retrofit2.Response

interface ComicsRepository {

    suspend fun getComics(limit: Int): Response<ComicResponse>?

}