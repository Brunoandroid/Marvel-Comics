package com.example.marvelcomics.data.repository

import com.example.marvelcomics.data.model.Comic
import com.example.marvelcomics.data.service.RequestApi
import com.example.marvelcomics.domain.repository.ComicsRepository

import javax.inject.Inject

class ComicsRepositoryImpl @Inject constructor(
    var requestApi: RequestApi
    ): ComicsRepository {

    override suspend fun getComics(limit: Int): List<Comic> {
        lateinit var comicList: List<Comic>
        try {
            val response = requestApi.getComics(limit)
            val body = response?.body()
            if(body!=null){
                comicList = body.data.comics
            }
        }catch (exception: Exception){
            comicList = listOf()
        }
        return comicList
    }
}



