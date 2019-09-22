package com.example.clickbustest.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.clickbustest.R
import android.R.attr.order
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.bumptech.glide.Glide
import com.example.clickbustest.data.Movie


class ListActivity : AppCompatActivity() {
    private var listPresenter: ListPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        listPresenter = ListPresenter()
        listPresenter!!.getMovie(supportFragmentManager)

    }

    override fun onResume() {
        super.onResume()
    }

    fun list(): List<Movie> {

        return listPresenter!!.showList()
    }

    fun getNextPage(page:Int) {
        listPresenter!!.getNextPage(page)
    }

}
