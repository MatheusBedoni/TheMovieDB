package com.example.clickbustest.ui.list

import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clickbustest.R
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import com.example.clickbustest.RecyclerViewOnClickListenerHack
import com.example.clickbustest.data.Movie
import androidx.recyclerview.widget.GridLayoutManager
import com.example.clickbustest.ui.details.DetailsActivity


class ListFragment : Fragment(), RecyclerViewOnClickListenerHack {

    private var recyclerView: RecyclerView? = null
    private var list: List<Movie>? = null
    private var adapter: ListAdapter? = null
    var mLayoutManager: LinearLayoutManager? = null
    private var loading = true
    var pastVisiblesItems: Int = 0
    var pageCont: Int = 2
    var visibleItemCount:Int = 0
    var totalItemCount:Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_oder, container, false)
        mLayoutManager = LinearLayoutManager(activity)
        recyclerView = view.findViewById(R.id.rv_list)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0)
                //check for scroll down
                {
                    visibleItemCount = mLayoutManager!!.getChildCount()
                    totalItemCount = mLayoutManager!!.getItemCount()
                    pastVisiblesItems = mLayoutManager!!.findFirstVisibleItemPosition()

                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= (totalItemCount/4)) {
                            Log.v("...", "metade Item Wow !")
                            (activity as ListActivity).getNextPage(pageCont)
                            pageCont++
                            loading = false
                        }

                    }
                    if (visibleItemCount + pastVisiblesItems >= (totalItemCount/2)) {

                        Log.v("...", "last Item Wow !")
                        adapter!!.addAll((activity as ListActivity).list())
                        loading = true
                    }
                }
            }
        })
        recyclerView!!.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
       } )

        list = (activity as ListActivity).list()
        configAdapter()

        return view
    }

    private fun configAdapter() {
        adapter = ListAdapter(this!!.activity!!, list as ArrayList<Movie>)
        mLayoutManager!!.orientation = LinearLayoutManager.VERTICAL

        recyclerView!!.setLayoutManager(mLayoutManager)
        adapter!!.setRecyclerViewOnClickListenerHack(this)
        recyclerView!!.setAdapter(adapter)
    }



    override fun onClickListener(view: View, position: Int) {
        val intent = Intent(activity, DetailsActivity::class.java)
        intent.putExtra("movie", list!!.get(position))
        activity!!.startActivity(intent)

    }
}