package com.example.marvelcomics.presentation.di

import com.example.marvelcomics.domain.repository.ComicsRepository
import com.example.marvelcomics.domain.usecases.GetComicsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModule {
    @Singleton
    @Provides
    fun provideGetComicsUseCase(
        comicsRepository: ComicsRepository
    ): GetComicsUseCase{
        return GetComicsUseCase(comicsRepository)
    }
}