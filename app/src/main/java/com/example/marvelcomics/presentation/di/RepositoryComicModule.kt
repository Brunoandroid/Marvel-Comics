package com.example.marvelcomics.presentation.di

import com.example.marvelcomics.data.repository.ComicsRepositoryImpl
import com.example.marvelcomics.data.service.RequestApi
import com.example.marvelcomics.domain.repository.ComicsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryComicModule {

    @Singleton
    @Provides
    fun provideComicsRepository(
        requestApi: RequestApi
    ): ComicsRepository{
        return ComicsRepositoryImpl(requestApi)
    }


}