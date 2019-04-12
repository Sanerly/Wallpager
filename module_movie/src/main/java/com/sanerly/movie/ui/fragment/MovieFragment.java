package com.sanerly.movie.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.arouter.RouterConfig;
import com.common.arouter.RouterUrl;
import com.sanerly.base.basic.BaseFragment;
import com.sanerly.movie.BR;
import com.sanerly.movie.R;
import com.sanerly.movie.databinding.MvFragmentMovieBinding;
import com.sanerly.movie.ui.adapter.MovieTabAdapter;
import com.sanerly.movie.viewmodel.MovieViewModel;

import java.util.ArrayList;

/**
 * 作者：Sanerly
 * 时间；2019/3/21 14:15
 */
@Route(path = RouterUrl.Movie.FRAGMENT_MOVIE)
public class MovieFragment extends BaseFragment<MvFragmentMovieBinding,MovieViewModel>{

    private String[] mTitles = {"正在售票", "热映", "即将上映"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    @Override
    protected int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.mv_fragment_movie;
    }

    @Override
    public int initVariableId() {
        return BR.movieViewModel;
    }

    @Override
    public void init() {
        super.init();
        for (int i = 0; i < mTitles.length; i++) {
            Fragment imageFragment = RouterConfig.getFragmentIndex(RouterUrl.Movie.FRAGMENT_MOVIE_LIST, i + 1);
            mFragments.add(imageFragment);
        }

        mBinding.viewPager.setAdapter(new MovieTabAdapter(getChildFragmentManager(), mFragments, mTitles));
        mBinding.SegmentTabLayout.setViewPager(mBinding.viewPager);
        mBinding.SegmentTabLayout.setCurrentTab(1);
    }
}
