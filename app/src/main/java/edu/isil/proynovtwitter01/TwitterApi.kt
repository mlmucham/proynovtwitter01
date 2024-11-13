package edu.isil.proynovtwitter01

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TwitterApi {
    private const val BASE_URL = "https://api.twitter.com/"

    fun createApiService(): TwitterApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(TwitterApiService::class.java)
    }
}

