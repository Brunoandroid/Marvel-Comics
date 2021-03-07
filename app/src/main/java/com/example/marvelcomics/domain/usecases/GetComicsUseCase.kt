package com.example.marvelcomics.domain.usecases

import com.example.marvelcomics.data.model.Comic
import com.example.marvelcomics.data.repository.ComicsRepositoryImpl
import com.example.marvelcomics.domain.repository.ComicsRepository
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(
    private val comicsRepository: ComicsRepository
) {

    suspend fun getComics(limit: Int): List<Comic>? = comicsRepository.getComics(limit)

}