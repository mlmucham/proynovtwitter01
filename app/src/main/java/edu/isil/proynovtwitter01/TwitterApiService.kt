package edu.isil.proynovtwitter01

import retrofit2.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TwitterApiService {

    @GET("2/tweets/search/recent")
    fun searchTweets(
        @Header("Authorization") authorization: String,
        @Query("query") query: String,
        @Query("max_results") maxResults: Int = 10
    ): Call<TwitterResponse>
}


