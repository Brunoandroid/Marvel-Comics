package com.example.marvelcomics.data.repository

import com.example.marvelcomics.data.model.ComicResponse
import com.example.marvelcomics.data.service.RequestApi
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class ComicsRepository @Inject constructor(private val requestApi: RequestApi) {

    suspend fun getComics(limit: Int): Response<ComicResponse>? {
        return requestApi.getComics(limit)
    }

}