package com.example.little_lemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Destination(val route:String){
    object DestinationOnBoardingScreen:Destination("DestinationOnBoarding")
    object DestinationHomeScreen:Destination("DestinationHome")
    object DestinationProfileScreen:Destination("DestinationProfile")
}

@Composable
fun navHost(navHostController: NavHostController){


    NavHost(navController = navHostController, startDestination = Destination.DestinationOnBoardingScreen.route){

        composable(Destination.DestinationOnBoardingScreen.route){
            Onboarding(navHostController)
        }

        composable(Destination.DestinationHomeScreen.route){
            HomeScreen(navHostController)
        }

        composable(Destination.DestinationProfileScreen.route){
            ProfileScreen(navHostController)
        }



    }

}
