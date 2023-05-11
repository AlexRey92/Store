package com.example.myapplication

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {
    @GET(value = "products")
    suspend fun getAllProducts():Response<MutableList<ProductsResponse>>
}

var retrofit=Retrofit.Builder()
    .baseUrl("https://fakestoreapi.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
val service:ApiService= retrofit.create(ApiService::class.java)