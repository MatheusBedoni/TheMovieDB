package com.example.clickbustest.data.network.response

import com.squareup.moshi.Json



data class MovieResponse constructor(@Json(name = "poster_path") val poster_path: String,
                                     @Json(name = "original_title") val original_title: String ,
                                     @Json(name = "vote_average") val vote_average: Float,
                                     @Json(name = "release_date") val release_date: String,
                                     @Json(name = "overview") val overview: String,
                                     @Json(name = "vote_count") val vote_count: Float
                                     ) {

}