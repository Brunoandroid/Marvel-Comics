package com.example.marvelcomics.ui.comics

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelcomics.data.model.ComicsResponse
import com.example.marvelcomics.repository.Repository
import retrofit2.Response

class ComicsViewModel @ViewModelInject constructor(
       private val repository: Repository
): ViewModel() {

   val comics: MutableLiveData<Response<ComicsResponse>> = MutableLiveData()

    suspend fun getComics(limit: Int){
        comics.value = repository.comicsRepository.getComics(limit)
    }

}