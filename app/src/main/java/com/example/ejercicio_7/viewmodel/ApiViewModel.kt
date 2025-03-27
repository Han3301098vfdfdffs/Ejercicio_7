package com.example.ejercicio_7.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejercicio_7.network.AppApi
import kotlinx.coroutines.launch
import java.io.IOException
class ApiViewModel:ViewModel(){
    var apiUiState by mutableStateOf("")
        private set

    init{
        getApiPhotos()
    }

    fun getApiPhotos(){
        viewModelScope.launch {
            try {
                val listResult = AppApi.retrofitService.getPhotos()
                apiUiState = listResult
            } catch(e: IOException){}
        }
    }
}

