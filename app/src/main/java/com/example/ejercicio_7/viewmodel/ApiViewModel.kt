package com.example.ejercicio_7.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejercicio_7.network.UnsplashApi
import kotlinx.coroutines.launch
import java.io.IOException
sealed interface ApiUiState{

    data class Success(val photos:String): ApiUiState

    object Error: ApiUiState

    object Loading: ApiUiState
}
class ApiViewModel:ViewModel(){
    var apiUiState: ApiUiState by mutableStateOf(ApiUiState.Loading)
        private set

    init{
        getApiPhotos()
    }

    fun getApiPhotos(){
        viewModelScope.launch {
            try {
                val listResult = UnsplashApi.retrofitService.getPhotos("nz4M8dQ96cpIOGaQOxKAxIvNwGwKKTnxIRq-buJVLSk")
                ApiUiState.Success(listResult)
            } catch(e: IOException){}
            ApiUiState.Error
        }
    }
}

