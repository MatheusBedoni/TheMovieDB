package com.example.clickbustest.ui.list

import com.example.clickbustest.data.mapper.MovieMapper
import com.example.clickbustest.data.network.ApiService
import com.example.clickbustest.data.network.response.MovieResponse
import com.example.clickbustest.data.network.response.MovieResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R.attr.order
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.clickbustest.R
import com.example.clickbustest.data.Movie


class ListPresenter():ListView {
    override fun getNextPage(page: Int) {
        apiService = ApiService()
        apiService!!.getInstance().getMovie("9ae0990e0eaaa39123ae3079d7378cfa",page)
            .enqueue(object : Callback<MovieResult>{
                override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {
                    if (response.isSuccessful()) {
                        val movieresult = response.body()
                        movielist = MovieMapper.responseForDomain( movieresult!!.results)

                    } else {

                    }
                }

                override fun onFailure(call: Call<MovieResult>, t: Throwable) {

                }
            })

    }


    override fun createFragment(fragment: FragmentManager) {
        var frag: ListFragment? = fragment.findFragmentByTag("mainFrag") as? ListFragment
        if (frag == null) {
            frag = ListFragment()
            Log.i("TAG", "fragment")
            val ft = fragment.beginTransaction()
            ft.replace(R.id.rl_fragment_container, frag, "mainFrag")
            ft.commit()
        }
    }

    var movielist: List<Movie>? =  null
    override fun showList(): List<Movie> {
        return this!!.movielist!!
    }

    var apiService: ApiService? = null
    override fun getMovie(fragment: FragmentManager) {

        apiService = ApiService()
        apiService!!.getInstance().getMovie("9ae0990e0eaaa39123ae3079d7378cfa",1)
            .enqueue(object : Callback<MovieResult>{
                override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {
                    if (response.isSuccessful()) {
                        val movieresult = response.body()
                         movielist = MovieMapper.responseForDomain( movieresult!!.results)
                        createFragment(fragment)
                    } else {

                    }
                }

                override fun onFailure(call: Call<MovieResult>, t: Throwable) {

                }
            })

    }





}