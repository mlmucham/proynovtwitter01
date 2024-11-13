package edu.isil.proynovtwitter01

data class TwitterResponse(
    val data: List<Tweet>?
)

data class Tweet(
    val id: String,
    val text: String
)
