package com.example.myapplication

data class ProductsResponse (
    val id: Int,
    val title:String,
    val price: Double,
    val description: String,
    val category:String,
    val image:String,
    val rating:Rating
)

data class Rating(
    val rate: Double,
    val count: Int
)


