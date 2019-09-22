package com.example.clickbustest.data.network

import com.example.clickbustest.data.network.response.MovieResult
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call;

interface MovieService {
    @GET("movie/popular")
    fun getMovie(@Query("api_key") chaveApi: String, @Query("page") pageIndex: Int): Call<MovieResult>
}