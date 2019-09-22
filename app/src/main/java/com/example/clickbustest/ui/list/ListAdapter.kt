package com.example.clickbustest.ui.list

import android.content.Context
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.clickbustest.R

import com.example.clickbustest.RecyclerViewOnClickListenerHack
import com.example.clickbustest.data.Movie




class ListAdapter(c: Context, private val list: ArrayList<Movie>) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private val layoutInflater: LayoutInflater
    private var recyclerViewOnClickListenerHack: RecyclerViewOnClickListenerHack? = null

    init {
        layoutInflater = c.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.i("LOG", "oscreateviewholder")
        val view = layoutInflater.inflate(R.layout.item_movie, parent, false) as View
        return MyViewHolder(view)
    }

    fun setRecyclerViewOnClickListenerHack(r: RecyclerViewOnClickListenerHack) {
        recyclerViewOnClickListenerHack = r
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.i("LOG", "onbindviewholder")

        holder.title.setText(list[position].title)
        holder.genre.setText(""+list[position].vote)
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w342/" + list[position].poster)
            .thumbnail(0.5f)
            .into(holder.poster)

        holder.note.setText(list[position].date)
    }

    override fun getItemCount(): Int {
        try {
            return list.size
        } catch (e: Exception) {

        }

        return 0
    }
    fun addAll(moveResults: List<Movie>) {
        try{
            for (result in moveResults) {
                list.add(result)
            }
        }catch (e: Exception){

        }

    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var title: TextView
        var genre: TextView
        var note: TextView
        var poster: ImageView

        init {
            title = itemView.findViewById(R.id.title)
            genre = itemView.findViewById(R.id.genre)
            note = itemView.findViewById(R.id.note)
            poster = itemView.findViewById(R.id.poster)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            if (recyclerViewOnClickListenerHack != null) {
                recyclerViewOnClickListenerHack!!.onClickListener(view, position)
            }
        }
    }
}