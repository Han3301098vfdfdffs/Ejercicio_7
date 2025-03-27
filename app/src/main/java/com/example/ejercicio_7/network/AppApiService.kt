package com.example.ejercicio_7.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val API_URL = "https://api.thecatapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(API_URL)
    .build()

interface AppApiService{
    @GET("v1/images/search?limit=1")
    suspend fun getPhotos():String
}

object AppApi{
    val retrofitService: AppApiService by lazy {
        retrofit.create(AppApiService::class.java)
    }
}