package com.example.tabexperiement



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an instance of the tab layout from the view.
        // Create an instance of the tab layout from the view.
// Set the text for each tab.
// Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText(R.string.top_stories))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tech_news))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.cooking))
// Set the tabs to fill the entire layout.
// Set the tabs to fill the entire layout.
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
// Use PagerAdapter to manage page views in fragments.

        viewPager.adapter = PagerAdapter(supportFragmentManager, tabLayout.tabCount)

        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}
