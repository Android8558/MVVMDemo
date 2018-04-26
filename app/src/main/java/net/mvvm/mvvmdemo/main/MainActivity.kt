package net.mvvm.mvvmdemo.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.mvvm.mvvmdemo.R
import net.mvvm.mvvmdemo.news.NewsListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        list_tab.setupWithViewPager(viewpager)
        list_tab.setTabTextColors(getColor(R.color.tab_unselected), getColor(R.color.colorAccent))
        val pagerAdapter = MainPagerAdapter(listOf(
                NewsListView(this, "休息视频"), NewsListView(this, "拓展资源")
                , NewsListView(this, "前端"), NewsListView(this, "福利")
                , NewsListView(this, "Android"), NewsListView(this, "iOS")),
                resources.getStringArray(R.array.newstitle).toMutableList())
        viewpager.adapter = pagerAdapter

    }
}
