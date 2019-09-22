package com.example.clickbustest.data.network.response

import com.squareup.moshi.Json



 data class MovieResult constructor(@Json(name = "results") val results: List<MovieResponse>){

}