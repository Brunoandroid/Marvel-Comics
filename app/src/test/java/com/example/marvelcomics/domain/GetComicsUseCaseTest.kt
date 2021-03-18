package com.example.marvelcomics.domain

import com.example.marvelcomics.domain.repository.ComicsRepository
import com.example.marvelcomics.domain.usecases.GetComicsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetComicsUseCaseTest {

    private val repository = mockk<ComicsRepository>()
    private val getComicsUseCase = GetComicsUseCase(repository)

    @Test
    fun `getComics return list with sucess`() = runBlocking {
        //GIVEN
        coEvery { repository.getComics(2) } returns ComicsFactory.comics

        //WHEN
        val result = getComicsUseCase.getComics(2)

        //THEN
        Assert.assertEquals(result!!.size, ComicsFactory.comics.size)
    }

}