package com.example.clickbustest.data.mapper

import android.util.Log
import com.example.clickbustest.data.Movie
import com.example.clickbustest.data.network.response.MovieResponse
import com.example.clickbustest.data.network.response.MovieResult

class MovieMapper {

    companion object {
        fun responseForDomain(listMovieResponse: List<MovieResponse>): List<Movie> {
            val movieList = ArrayList<Movie>()

            for (movieResponse in listMovieResponse) {
                try {
                    val movie = Movie(
                        movieResponse.original_title,
                        movieResponse.poster_path,
                        movieResponse.vote_average,
                        movieResponse.release_date,
                        movieResponse.overview,
                        " ",
                        movieResponse.vote_count
                    )
                    Log.i("LOG", "movie " + movieResponse.original_title)
                    Log.i("LOG", "movie " + movieResponse.poster_path)
                    movieList.add(movie)
                }catch(e: Exception){}


            }

            return movieList
        }
    }
}