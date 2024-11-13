package edu.isil.proynovtwitter01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log // Asegúrate de importar la clase Log

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tweetAdapter: TweetAdapter
    private val bearerToken = "Bearer AAAAAAAAAAAAAAAAAAAAAJnxugEAAAAAXp0zHnGVu2F7HFYWdkOejgHMy8U%3DBvokdrgPunm94Fj5zWrQVRdQL7Hu61r4xafzFAZySYcrdQlTpB"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        tweetAdapter = TweetAdapter(emptyList())
        recyclerView.adapter = tweetAdapter

        fetchTweets()
    }

    private fun fetchTweets() {
        val twitterApiService = TwitterApi.createApiService()
        val call = twitterApiService.searchTweets(bearerToken, query = "data science", maxResults = 10)

        call.enqueue(object : Callback<TwitterResponse> {
            override fun onResponse(call: Call<TwitterResponse>, response: Response<TwitterResponse>) {
                if (response.isSuccessful) {
                    val tweets = response.body()?.data ?: emptyList()
                    tweetAdapter.updateTweets(tweets)

                    // Agregar log para ver los datos recibidos
                    Log.d("API_RESPONSE", "Tweets recibidos: $tweets")
                } else {
                    // Manejar error de la respuesta no exitosa
                    Log.e("API_ERROR", "Error en la respuesta: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<TwitterResponse>, t: Throwable) {
                // Manejar error de la llamada fallida
                Log.e("API_FAILURE", "Error al hacer la llamada a la API", t)
            }
        })
    }
}


