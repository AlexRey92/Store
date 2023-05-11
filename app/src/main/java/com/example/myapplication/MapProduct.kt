package com.example.myapplication

fun ProductsResponse.MapToProduct()=Cloth(
    id,title,price,description,category,image,rating.rate

)
