package com.example.marvelcomics.repository

import com.example.marvelcomics.data.model.ComicResponse
import com.example.marvelcomics.data.service.RequestApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicsRepository @Inject constructor(private val requestApi: RequestApi) {

    suspend fun getComics(limit: Int): Response<ComicResponse> {
        return requestApi.getComics(limit)
    }

}