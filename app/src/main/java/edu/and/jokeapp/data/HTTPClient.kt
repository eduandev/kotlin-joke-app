package edu.and.jokeapp.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HTTPClient {

    private const val BASE_URL = "https://api.tiagoaguiar.co/jokerapp/"
            const val API_KEY = "e7a785df-c171-47de-825e-2ce8a15a8c02"

    private fun httpClient() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient
               .Builder()
               .addInterceptor(logging)
               .build()
    }

    fun retrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient())
            .build()
    }
}