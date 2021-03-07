package com.example.marvelcomics.domain.repository


import com.example.marvelcomics.data.model.Comic

interface ComicsRepository {

    suspend fun getComics(limit: Int): List<Comic>?

}