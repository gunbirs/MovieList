package com.example.loadposter.network

import com.example.loadposter.models.Category
import com.example.loadposter.models.CategoryDetails
import com.example.loadposter.models.Poster
import com.example.loadposter.network.URLs
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Contains method calls for all the api's for showing movie posters.
 */
interface PostersApi {
    @GET(URLs.URL_FIRST_ENDPOINT)
    suspend fun getCategories(): Response<Category>

    @GET(URLs.URL_SECOND_ENDPOINT)
    suspend fun getCategoryDetails(@Path("namespace")namespace: String, @Path("alias")alias: String): Response<CategoryDetails>

    @GET(URLs.URL_THIRD_ENDPOINT)
    suspend fun getPoster(@Path("namespace")namespace: String, @Path("alias")alias: String): Response<Poster>
}