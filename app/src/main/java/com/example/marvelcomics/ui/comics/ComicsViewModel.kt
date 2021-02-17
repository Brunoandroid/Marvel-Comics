package com.example.marvelcomics.ui.comics

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.data.model.ComicResponse
import com.example.marvelcomics.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ComicsViewModel @ViewModelInject constructor(
       private val repository: Repository
): ViewModel() {

   val comic: MutableLiveData<Response<ComicResponse>> = MutableLiveData()


    suspend fun getComics(limit: Int){
        viewModelScope.launch {
            comic.value = repository.comicsRepository.getComics(limit)
        }

    }

}