package com.example.little_lemon.ViewModel.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitObject {

    private  val client by lazy{
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory( GsonConverterFactory.create())
            .build()
    }


    val menuRepository:MenuServiceInterface by lazy {
        client.create(MenuServiceInterface::class.java)
    }
}