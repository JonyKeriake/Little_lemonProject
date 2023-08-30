package com.example.little_lemon.ViewModel.HomeScreen

import androidx.navigation.NavHostController

sealed class HomeScreenEvents{

    data class OnProfileImageClicked(val click:Boolean,val navHostController: NavHostController):HomeScreenEvents()
    object OnStart:HomeScreenEvents()

}
