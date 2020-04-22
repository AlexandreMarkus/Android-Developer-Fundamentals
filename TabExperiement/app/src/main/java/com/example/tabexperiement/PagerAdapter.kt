package com.example.tabexperiement

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class PagerAdapter(fm: FragmentManager, private var mNumOfTabs: Int) :
    FragmentStatePagerAdapter(fm) {

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    override fun getItem(position: Int): Fragment? {
        return when(position){
            0-> TabFragment1()
            1-> TabFragment2()
            2-> TabFragment3()
            else->{
                null
            }
        }
    }

    /**
     * Return the number of views available.
     */
    override fun getCount(): Int {
        return mNumOfTabs
    }

}