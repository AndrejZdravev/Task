package com.andrejzdravev.task.network

import android.util.Log
import com.andrejzdravev.task.`interface`.CommonResponseListener
import com.andrejzdravev.task.model.Factss
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkCall {
    private val TAG = "NetworkCall"

    fun commonNetworkCall(
            listener: CommonResponseListener,
            baseUrl: String
    ) {
        val okHttpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(40, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val call = retrofit.create(RetrofitApi::class.java).getFacts()

        call.enqueue(object : Callback<Factss> {
            override fun onResponse(call: Call<Factss>, response: Response<Factss>) {
                listener.onSuccessResponse(response.body(), response.code())
            }

            override fun onFailure(call: Call<Factss>, t: Throwable) {
                Log.e(TAG, "" + t)
            }
        })
    }
}