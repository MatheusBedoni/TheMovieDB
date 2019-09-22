package com.example.clickbustest.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class ApiService {
    private var INSTANCE: MovieService? = null

    fun getInstance(): MovieService {
        if (INSTANCE == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            INSTANCE = retrofit.create<MovieService>(MovieService::class.java!!)
        }

        return this!!.INSTANCE!!
    }
}