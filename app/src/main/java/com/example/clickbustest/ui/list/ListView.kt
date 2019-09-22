package com.example.clickbustest.ui.list

import androidx.fragment.app.FragmentManager
import com.example.clickbustest.data.Movie

interface ListView {
    fun showList(): List<Movie>
    fun createFragment(fragment: FragmentManager)
    fun getMovie(fragment: FragmentManager)
    fun getNextPage(page: Int)
}