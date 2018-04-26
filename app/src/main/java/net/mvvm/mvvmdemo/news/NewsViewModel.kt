package net.mvvm.mvvmdemo.news

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.widget.Toast
import net.mvvm.mvvmdemo.base.ViewModel
import net.mvvm.mvvmdemo.data.bean.NewsList
import net.mvvm.mvvmdemo.data.source.RemoteDataSource
import net.mvvm.mvvmdemo.http.InfoCallBack

/**
 * <p>类说明</p>
 * @author liuzhaohong 2018/4/24 15:10
 * @version V1.0
 * @name NewsViewModel
 */
class NewsViewModel(private val context: Context, val category: String) : ViewModel {
    val TAG = "NewsViewModel"

    val loading = ObservableBoolean()

    val newsList = ObservableArrayList<NewsList.ResultsBean>()

    public fun refreshData() {
        Toast.makeText(context, "刷新中。。。", Toast.LENGTH_SHORT).show()
        loading.set(true)
        val dataSource = RemoteDataSource()
        dataSource.getRandData(category, object : InfoCallBack<NewsList> {
            override fun onSuccess(data: NewsList) {
                if (!data.isError) {
                    newsList.clear()
                    newsList.addAll(data.results)
                }
                loading.set(false)
            }

            override fun onError(str: String) {
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
                loading.set(false)
            }
        })

    }

}