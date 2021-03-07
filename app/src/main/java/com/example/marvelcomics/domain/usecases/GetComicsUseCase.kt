package com.example.marvelcomics.domain.usecases

import com.example.marvelcomics.data.model.Comic
import com.example.marvelcomics.data.repository.ComicsRepositoryImpl
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(
    private val comicsRepositoryImpl: ComicsRepositoryImpl
) {

    suspend fun getComics(limit: Int): List<Comic>? = comicsRepositoryImpl.getComics(limit)

}