package net.mvvm.mvvmdemo.news

import android.databinding.ObservableField
import net.mvvm.mvvmdemo.base.ViewModel
import net.mvvm.mvvmdemo.data.bean.NewsList

/**
 * <p>类说明</p>
 * @author liuzhaohong 2018/4/24 15:29
 * @version V1.0
 * @name ItemViewModel
 */
class ItemViewModel : ViewModel {
    //Model
    lateinit var newsItem: NewsList.ResultsBean
    //data field
    val createdAt = ObservableField<String>()
    val desc = ObservableField<String>()
    val who = ObservableField<String>()

    public fun setItems(items: NewsList.ResultsBean) {
        newsItem = items
        createdAt.set(newsItem.createdAt)
        desc.set(newsItem.desc)
        who.set(newsItem.who)
    }


}