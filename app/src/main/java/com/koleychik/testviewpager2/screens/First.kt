package com.koleychik.testviewpager2.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.koleychik.testviewpager2.R
import kotlinx.android.synthetic.main.fragment_first.view.*


class First : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        view.img.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_viewPagerFragment_to_home2)
        }

        return view
    }
}