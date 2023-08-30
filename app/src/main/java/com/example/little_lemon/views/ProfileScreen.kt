package com.example.little_lemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(
    navHostController: NavHostController
){

    val context= LocalContext.current
val sharedPreferences=SharedPreferences(context)
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(150.dp)
            )

        }


        Column(modifier = Modifier.padding(20.dp)) {

            Text(
                text = "Personal information :",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,

                )

            Text(
                    text = "First Name is :"+sharedPreferences.getFirstName("firstName"),
            modifier = Modifier
                .padding(top = 20.dp)
            )

            Text(
                text = "Last Name is :"+sharedPreferences.getLastName("lastName"),
                modifier = Modifier
                    .padding(top = 20.dp)
            )

            Text(
                text = "email Name is :"+sharedPreferences.getEmail("email"),
                modifier = Modifier
                    .padding(top = 20.dp)
            )

        }


        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
            ) {
            Button(
                onClick = {
                          sharedPreferences.clear()
                    navHostController.navigate(
                        Destination.DestinationOnBoardingScreen.route
                    )

                },
                modifier = Modifier.padding(40.dp).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.yellow1)),
                shape = RoundedCornerShape(20)

            ) {
                Text(text = "LogOut")
            }
        }


    }




}