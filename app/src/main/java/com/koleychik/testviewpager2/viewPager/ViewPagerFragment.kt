package com.koleychik.testviewpager2.viewPager

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.koleychik.testviewpager2.R
import com.koleychik.testviewpager2.screens.First
import com.koleychik.testviewpager2.screens.Second
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.view_pager_layout, container, false)

        val viewPagerFragment: ViewPager2 = view.findViewById(R.id.viewPager)
        val bottomMenuMain: BottomNavigationView = view.findViewById(R.id.bottomNavBar)

        val fragmentList = listOf(
            First(), Second()
        )

        val adapter = ViewPagerAdapter(
            list = fragmentList,
            fm = requireActivity().supportFragmentManager,
            lifecycle = lifecycle
        )

        viewPagerFragment.adapter = adapter

        viewPagerFragment.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> bottomMenuMain.menu.findItem(R.id.image).isChecked = true
                    1 -> bottomMenuMain.menu.findItem(R.id.list).isChecked = true
                }
            }
        })

        bottomMenuMain.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.image -> {
                    viewPagerFragment.currentItem = 0
                    true
                }
                R.id.list -> {
                    viewPagerFragment.currentItem = 1
                    true
                }

                else -> false
            }
        }

        return view
    }
}