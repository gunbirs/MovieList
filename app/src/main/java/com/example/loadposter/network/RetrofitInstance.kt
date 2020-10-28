package com.example.loadposter.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    /**
     * Create an instance of Retrofit object
     */
    private val retrofitInstance: Retrofit? = Retrofit.Builder()
                    .baseUrl(URLs.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    /**
     * Create network request object of specifc type T
     * @param - clazz - Class name representing end point type.
     */
    fun <T> createNetworkRequest(clazz: Class<T>): T? {
        return retrofitInstance?.create(clazz)
    }
}