package com.example.little_lemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.little_lemon.ViewModel.HomeScreen.HomeScreenEvents
import com.example.little_lemon.ViewModel.HomeScreen.HomeScreenVM


@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeScreenVM = viewModel()
){

    viewModel.onEvent(HomeScreenEvents.OnStart)

    val state=viewModel.state


    Column(modifier = Modifier.fillMaxSize()) {


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription ="logo",
                modifier=Modifier.size(150.dp) )

            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription ="profile",
                modifier=Modifier.size(50.dp).clickable {
                    viewModel.onEvent(HomeScreenEvents.OnProfileImageClicked(click = true, navHostController = navHostController))
                } )






        }

    }

}