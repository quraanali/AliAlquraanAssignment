package com.quraanali.assignment.model.repository.remote

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit


class RetrofitService {


    private lateinit var retrofit: Retrofit

    fun retrofitService(): AssignmentAPI {

        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val original = chain.request()




            val requestBuilder = original.newBuilder()
                .addHeader("Accept", "application/json")








             val request = requestBuilder.build()
            chain.proceed(request)


        }

        httpClient.callTimeout(25, TimeUnit.SECONDS)
        httpClient.connectTimeout(25, TimeUnit.SECONDS)
        httpClient.readTimeout(25, TimeUnit.SECONDS)
        httpClient.writeTimeout(25, TimeUnit.SECONDS)



        retrofit = Retrofit.Builder()
            .client(httpClient.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("")
            .build()

        Log.e("status", retrofit.baseUrl().toString())

        return retrofit.create(AssignmentAPI::class.java)
    }




}