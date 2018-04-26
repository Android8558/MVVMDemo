package net.mvvm.mvvmdemo.news

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.widget.FrameLayout
import net.mvvm.mvvmdemo.data.bean.NewsList
import net.mvvm.mvvmdemo.databinding.NewsListViewBinding

@SuppressLint("ViewConstructor")
/**
 * <p>类说明</p>
 * @author liuzhaohong 2018/4/24 15:09
 * @version V1.0
 * @name NewsListView
 */
class NewsListView(context: Context, category: String) : FrameLayout(context) {
    init {
        val listBinding = NewsListViewBinding.inflate(LayoutInflater.from(context), this, true)
        val layoutManager = LinearLayoutManager(getContext())
        listBinding.recyclerView.layoutManager = layoutManager
        listBinding.viewModel = NewsViewModel(context, category)
        listBinding.refreshFab.setOnClickListener {
            listBinding.viewModel!!.refreshData()
        }
        val news = ArrayList<NewsList.ResultsBean>()
        val adapter = MyAdapter<NewsList.ResultsBean>(context, news)
        listBinding.recyclerView.adapter = adapter
        listBinding.viewModel!!.refreshData()
    }


}