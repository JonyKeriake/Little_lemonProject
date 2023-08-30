package com.example.little_lemon.ViewModel.HomeScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.little_lemon.Destination
import com.example.little_lemon.ViewModel.api.MenuServicesImplementation
import com.example.little_lemon.ViewModel.api.Resource
import kotlinx.coroutines.launch

class HomeScreenVM(
    private val menuServicesImplementation: MenuServicesImplementation=MenuServicesImplementation()
):ViewModel() {

    var state by mutableStateOf(HomeScreenStates())

  fun onEvent( event: HomeScreenEvents){
        when(event){

            is HomeScreenEvents.OnProfileImageClicked->{
                event.navHostController.navigate(Destination.DestinationProfileScreen.route)
                state=state.copy(clickOnImageProfile=false)
            }
            is HomeScreenEvents.OnStart->{

                getData()

            }

        }
    }



  private fun  getData(){

        viewModelScope.launch {
            val response=menuServicesImplementation.getMenuItems()

            response.collect{

                when(it){
                    is Resource.Loading->{
                        Log.d("qweewq","loading")
                    }
                    is Resource.Success->{
                        if(it.data!=null){
                            Log.d("qweewq",it.data.toString())
                        }
                    }
                    is Resource.Error->{
                        Log.d("qweewq",it.message.toString())
                    }

                }

            }

        }
    }
}