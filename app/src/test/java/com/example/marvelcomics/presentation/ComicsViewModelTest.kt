package com.example.marvelcomics.presentation

import android.app.Application
import com.example.marvelcomics.domain.usecases.GetComicsUseCase
import com.example.marvelcomics.presentation.ui.comics.ComicsViewModel
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class ComicsViewModelTest {

    private val getComicsUseCase = mockk<GetComicsUseCase>()

    private val comicsViewModel = ComicsViewModel(getComicsUseCase, application = Application())

    @Test
    fun `verified input return empty`() {

        val name = ""
        val result = comicsViewModel.verified_input(name)

        Assert.assertEquals(result, true)

    }

}