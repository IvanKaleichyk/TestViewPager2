package com.koleychik.testviewpager2.screens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.koleychik.testviewpager2.R
import kotlinx.android.synthetic.main.item.view.*

class RvAdapter(private val list: List<String>) : RecyclerView.Adapter<RvAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int  = list.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(text : String){
            itemView.mainText.text = text
        }

    }
}