package com.example.happid

import com.example.happid.models.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MyApi {
    @POST("users")
    fun createUser(@Body user: UserModel): Call<UserModel>
}