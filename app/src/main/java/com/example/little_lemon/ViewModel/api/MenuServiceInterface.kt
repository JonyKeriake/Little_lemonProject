package com.example.little_lemon.ViewModel.api

import com.example.little_lemon.Model.MenuResponse
import retrofit2.http.*

interface MenuServiceInterface {

@GET("Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
suspend fun getMenuItems():MenuResponse
}