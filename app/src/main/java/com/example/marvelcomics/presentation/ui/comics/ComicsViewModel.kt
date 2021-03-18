package com.example.marvelcomics.presentation.ui.comics

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.data.model.Comic
import com.example.marvelcomics.domain.usecases.GetComicsUseCase

import kotlinx.coroutines.launch

class ComicsViewModel @ViewModelInject constructor(
    private val getComicsUseCase: GetComicsUseCase,
    application: Application
) : AndroidViewModel(application) {

    val comic: MutableLiveData<List<Comic>> = MutableLiveData()

    suspend fun getComics() {
        viewModelScope.launch {
            comic.value = getComicsUseCase.getComics(10)
        }
    }

    fun verified_input(name: String): Boolean{
        if (name != ""){
            return false
        }
        return true
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