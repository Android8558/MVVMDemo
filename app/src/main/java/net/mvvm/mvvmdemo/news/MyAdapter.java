package net.mvvm.mvvmdemo.news;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.mvvm.mvvmdemo.BR;
import net.mvvm.mvvmdemo.data.bean.NewsList;
import net.mvvm.mvvmdemo.databinding.NewsDetailViewBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<T> mDatas;
    private Context mContext;

    public MyAdapter(Context context, List<T> datas) {
        mDatas = datas;
        mContext = context;
    }

    public void replaceData(List<T> newData) {
        mDatas = newData;
        notifyDataSetChanged();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsDetailViewBinding mBinding =
                NewsDetailViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        convert(holder, mDatas.get(position));
    }

    public void convert(RecyclerView.ViewHolder holder, T t) {
        NewsList.ResultsBean resultsBean = (NewsList.ResultsBean) t;
        ItemViewModel itemViewModel = new ItemViewModel();
        itemViewModel.setItems(resultsBean);
        ((ItemViewHolder) holder).setBinding(BR.viewModel, itemViewModel);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding mBinding;

        public ItemViewHolder(View v) {
            super(v);
            mBinding = DataBindingUtil.bind(v);
        }

        public ItemViewHolder setBinding(int variableId, Object object) {
            mBinding.setVariable(variableId, object);
            mBinding.executePendingBindings();
            mBinding.setVariable(BR.event, new EventListener() {
                @Override
                public void itemClick(@NotNull View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.parse(((NewsList.ResultsBean) mDatas.get(getAdapterPosition())).getUrl());
                    intent.setData(uri);
                    mContext.startActivity(intent);
                }
            });
            return this;
        }
    }
}
