package com.example.little_lemon.Model


import com.example.little_lemon.ViewModel.api.Kyes
import com.google.gson.annotations.SerializedName


data class MenuResponse(

    @SerializedName(Kyes.menu)
    val menu: List<Items>

) {
    data class Items(
        @SerializedName(Kyes.id)
        val id: Int,
        @SerializedName(Kyes.title)
    val title: String,

    @SerializedName(Kyes.description)
    val description: String,

    @SerializedName(Kyes.price)
    val price: String,

    @SerializedName(Kyes.image)
    val image: String

    )
}
