package com.example.marvelcomics.ui.comics

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.data.model.ComicResponse
import com.example.marvelcomics.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ComicsViewModel @ViewModelInject constructor(
       private val repository: Repository,
       application: Application
): AndroidViewModel(application) {

   val comic: MutableLiveData<Response<ComicResponse>> = MutableLiveData()


    suspend fun getComics(limit: Int){
        viewModelScope.launch {
            comic.value = repository.comicsRepository.getComics(limit)
        }

    }

    // Verifica se tem internet
    fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
                Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

}