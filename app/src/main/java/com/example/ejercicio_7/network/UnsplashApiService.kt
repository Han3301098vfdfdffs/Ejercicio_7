package com.example.ejercicio_7.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val API_URL = "https://api.unsplash.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(API_URL)
    .build()

interface UnsplashApiService{
    @GET("/photos/random")
    suspend fun getPhotos(@Query("client_id") clientId:String):String
}

object UnsplashApi{
    val retrofitService: UnsplashApiService by lazy {
        retrofit.create(UnsplashApiService::class.java)
    }
}