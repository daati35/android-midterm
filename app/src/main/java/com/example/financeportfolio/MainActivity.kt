package com.example.financeportfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.dg_ia_view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.dg_ia_tab_layout)

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // გვარი იწყება თანხმოვანზე, ამიტომ Vertical
        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Input"
                1 -> "Analytics"
                2 -> "Profile"
                else -> ""
            }
        }.attach()
    }
}
