package edu.isil.proynovtwitter01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TweetAdapter(private var tweets: List<Tweet>) :
    RecyclerView.Adapter<TweetAdapter.TweetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tweet, parent, false)
        return TweetViewHolder(view)
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val tweet = tweets[position]
        holder.bind(tweet)
    }

    override fun getItemCount(): Int = tweets.size

    fun updateTweets(newTweets: List<Tweet>) {
        tweets = newTweets
        notifyDataSetChanged()
    }

    class TweetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tweetText: TextView = itemView.findViewById(R.id.tweetText)

        fun bind(tweet: Tweet) {
            tweetText.text = tweet.text
        }
    }
}
