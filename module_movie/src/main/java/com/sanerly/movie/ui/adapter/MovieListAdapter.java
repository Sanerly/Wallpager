package com.sanerly.movie.ui.adapter;

import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;

import com.sanerly.base.adapter.BaseBindingAdapter;
import com.sanerly.movie.R;
import com.sanerly.movie.databinding.MvItemMovieLayoutBinding;
import com.sanerly.movie.viewmodel.ItemViewModel;

/**
 * 作者：Sanerly
 * 时间；2019/4/3 10:45
 */
public class MovieListAdapter extends BaseBindingAdapter<ItemViewModel,MvItemMovieLayoutBinding>{

    public MovieListAdapter(ObservableArrayList<ItemViewModel> datas) {
        super(datas);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.mv_item_movie_layout;
    }

    @Override
    protected void onBindItem(MvItemMovieLayoutBinding binding, ItemViewModel item, int position) {
        binding.setItemViewModel(item);
    }


}
