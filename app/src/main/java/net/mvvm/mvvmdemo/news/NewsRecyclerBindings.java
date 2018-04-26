package net.mvvm.mvvmdemo.news;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import net.mvvm.mvvmdemo.data.bean.NewsList;

import java.util.List;

/**
 * <p>类说明</p>
 *
 * @author liuzhaohong 2018/4/26 11:38
 * @version V1.0
 * @name NewsRecyclerBindings
 */

public class NewsRecyclerBindings {
    @BindingAdapter("app:items")
    public static void setItems(RecyclerView recyclerView, List<NewsList.ResultsBean> beanList) {
        MyAdapter<NewsList.ResultsBean> adapter = (MyAdapter<NewsList.ResultsBean>) recyclerView.getAdapter();
        adapter.replaceData(beanList);
    }
}
