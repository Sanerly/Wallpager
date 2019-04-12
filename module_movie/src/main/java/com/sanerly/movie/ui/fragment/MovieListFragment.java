package com.sanerly.movie.ui.fragment;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.api.Api;
import com.common.arouter.RouterUrl;
import com.common.util.FUtils;
import com.sanerly.base.basic.BaseFragment;
import com.sanerly.movie.BR;
import com.sanerly.movie.R;
import com.sanerly.movie.databinding.MvFragmentMovieListBinding;
import com.sanerly.movie.viewmodel.MovieListViewModel;

/**
 * 作者：Sanerly
 * 时间；2019/4/2 16:28
 */

@Route(path = RouterUrl.Movie.FRAGMENT_MOVIE_LIST)
public class MovieListFragment extends BaseFragment<MvFragmentMovieListBinding, MovieListViewModel> {

    private int mIndex;


    public ObservableField<String> mPath = new ObservableField<>();

    @Override
    protected int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.mv_fragment_movie_list;
    }

    @Override
    public int initVariableId() {
        return BR.listViewModel;
    }

    @Override
    public void initParam() {
        super.initParam();
        mIndex = FUtils.getFragmentIndex(this, "index");
        if (mIndex == 1) {
            mPath.set(Api.MovieApi.MOVIE_SOLD);
        } else if (mIndex == 2) {
            mPath.set(Api.MovieApi.MOVIE_HOT);
        } else {
            mPath.set(Api.MovieApi.MOVIE_COMING);
        }
    }

    @Override
    public void init() {
        super.init();

    }

    @Override
    public void loadData() {
        super.loadData();
        mViewModel.loadData(mPath);
    }
}
