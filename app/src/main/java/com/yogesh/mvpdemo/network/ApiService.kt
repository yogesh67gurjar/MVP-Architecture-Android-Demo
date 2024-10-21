package com.yogesh.mvpdemo.network

import com.yogesh.mvpdemo.model.CatFactResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("fact")
    fun getFact(): Call<CatFactResponse>
}