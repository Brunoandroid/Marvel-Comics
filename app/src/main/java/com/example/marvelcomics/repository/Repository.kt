package com.example.marvelcomics.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    comicsRepository: ComicsRepository,
    cartComicRepository: CartComicRepository
) {
    val comicsRepository = comicsRepository
    val cartComicRepository = cartComicRepository
}