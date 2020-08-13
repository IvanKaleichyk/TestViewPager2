package com.koleychik.testviewpager2.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.koleychik.testviewpager2.R
import kotlinx.android.synthetic.main.fragment_second.view.*
import java.util.*

class Second : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val adapter = RvAdapter(makeList())

        view.rv.adapter = adapter

        return view
    }

    fun makeList() : MutableList<String>{
        val list = mutableListOf<String>()

        for (i in (0..100)){
            list.add("hello " + Random().nextInt(1000))
        }
        return list
    }

}