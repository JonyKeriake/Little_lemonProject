package com.example.little_lemon

import android.content.Context
import android.content.SharedPreferences
import android.util.Log


class SharedPreferences (context: Context){


    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("My App", Context.MODE_PRIVATE)

    val editor=sharedPreferences.edit()

fun setFirstName(firstName:String){
    editor.putString("firstName",firstName)
    editor.apply()
}

    fun setLastName(lastName:String){
        editor.putString("lastName",lastName)
        editor.apply()
    }

    fun setEmail(email:String){
        editor.putString("email",email)
        editor.apply()
    }



    fun getFirstName(firstName:String):String?{
        return sharedPreferences.getString(firstName,"")
    }

    fun getLastName(lastName:String):String?{
        return  sharedPreferences.getString(lastName,"")
    }

    fun getEmail(email:String):String?{
        return  sharedPreferences.getString(email,"")
    }


    fun clear(){
        editor.clear().apply()
    }








}