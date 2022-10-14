package edu.and.jokeapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {

    @GET("jokes/categories")
    fun findAllCategories(@Query("apiKey") apiKey: String = HTTPClient.API_KEY) : Call<List<String>>
}