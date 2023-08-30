package com.example.little_lemon

import android.content.Context
import android.view.Display.Mode
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Onboarding ( navHostController: NavHostController){

var context= LocalContext.current

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    val sharedPreferences= SharedPreferences(context)

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription ="logo",
                modifier=Modifier.size(150.dp) )

        }

        Row (
            modifier = Modifier
                .background(color = colorResource(id = R.color.gray1))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
                ){
            
            Text(
                text = "Let's get to know you",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(30.dp)
            )
            
        }

        Column(modifier = Modifier.padding(20.dp),) {

            Text(
                text = "Personal information :",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,

                )
            
            OutlinedTextField(value = firstName, onValueChange = {firstName=it},
                label = {
                    Text(text = "First Name")
                },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(value = lastName, onValueChange = {lastName=it},
                label = {
                    Text(text = "Last Name")
                },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            )


            OutlinedTextField(value = email, onValueChange = {email=it},
                label = {
                    Text(text = "Email")
                },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            )
            
            
            Button(
                onClick = {
                          if(firstName==""||lastName==""||email==""){
                              Toast.makeText(context,"Registration unsuccessful. Please enter all data.",Toast.LENGTH_SHORT).show()
                          }
                    else{
                              navHostController.navigate(Destination.DestinationHomeScreen.route)
                              sharedPreferences.setFirstName(firstName)
                              sharedPreferences.setLastName(lastName)
                              sharedPreferences.setEmail(email)
                              Toast.makeText(context,"Registration successful!",Toast.LENGTH_SHORT).show()

                          }

                          },
                modifier = Modifier.padding(top = 40.dp).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.yellow1)),
                shape = RoundedCornerShape(20)
                
            ) {
                Text(text = "Register")
            }


            

        }





        
    }
    
    
    
}