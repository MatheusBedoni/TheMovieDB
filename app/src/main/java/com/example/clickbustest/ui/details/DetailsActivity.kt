package com.example.clickbustest.ui.details

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.clickbustest.R

import kotlinx.android.synthetic.main.activity_details.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Parcelable
import android.util.Log
import com.bumptech.glide.Glide
import com.example.clickbustest.data.Movie


class DetailsActivity : AppCompatActivity() {
    private var movie: Movie? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)

        if (intent != null && intent.extras != null && intent.extras!!.getParcelable<Parcelable>("movie") != null) {
            movie = intent.extras!!.getParcelable<Movie>("movie")
        }
        init()

    }

    override fun onResume() {
        super.onResume()
        Log.i("LOG", "movie:"+movie!!.title)

    }

    fun init(){
        original_title.setText(movie!!.title)
        vote.setText(""+movie!!.vote)
        overview.setText(movie!!.overview)
        tagline.setText(""+movie!!.tagline)
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w342/"+ movie!!.poster)
            .thumbnail(0.5f)
            .into(poster)
    }

}
