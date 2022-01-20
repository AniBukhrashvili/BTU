package com.example.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.btuclassroom.fragments.CalendarFragment
import com.example.btuclassroom.fragments.CoursesFragment
import com.example.btuclassroom.fragments.ProfileFragment

class ViewPagerFragmentAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> CoursesFragment()
            1 -> CalendarFragment()
            2 -> ProfileFragment()
            else -> CoursesFragment()
        }
    }
}