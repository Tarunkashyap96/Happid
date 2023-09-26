package com.example.happid

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
     private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://crudcrud.com/api/790fd109405946b089e3629e9d3e887b/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val myApi: MyApi = retrofit.create(MyApi::class.java)
}