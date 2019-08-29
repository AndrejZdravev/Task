package com.andrejzdravev.task.network

import com.andrejzdravev.task.model.Factss
import com.andrejzdravev.task.network.WebUrls.Companion.BASE_URL
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {
    @GET(BASE_URL)
    fun getFacts(): Call<Factss>
}
