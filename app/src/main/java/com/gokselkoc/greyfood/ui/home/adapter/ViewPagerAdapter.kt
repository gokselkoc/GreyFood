package com.gokselkoc.greyfood.ui.home.adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.gokselkoc.greyfood.ui.home.ViewPagerFragment



class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    private val counts: Int
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) =
        ViewPagerFragment.newInstance(
            position
        )

    override fun getCount(): Int {
        return counts
    }
}
