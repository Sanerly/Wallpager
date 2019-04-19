package com.sanerly.home.ui.activity;

import android.databinding.ObservableArrayList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.common.arouter.RouterConfig;
import com.common.arouter.RouterUrl;
import com.common.tab.TabEntity;
import com.common.widget.TitleLayout;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.sanerly.base.basic.BaseActivity;
import com.sanerly.base.basic.BaseViewModel;
import com.sanerly.base.util.LogUtils;
import com.sanerly.base.util.StatusBarUtils;
import com.sanerly.home.BR;
import com.sanerly.home.R;
import com.sanerly.home.databinding.ActivityHomeBinding;
import com.sanerly.home.model.HomeModel;

import java.util.ArrayList;

import cn.ycbjie.ycstatusbarlib.bar.StateAppBar;


public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeModel> {

    private String[] mTitles = {"壁纸", "电影", "阅读", "我的"};
    private int[] mIconUnselectIds = {
            R.drawable.ic_home_paper_normal, R.drawable.ic_home_movie_normal,
            R.drawable.ic_home_read_narmal, R.drawable.ic_home_mine_normal};
    private int[] mIconSelectIds = {
            R.drawable.ic_home_paper_press, R.drawable.ic_home_movie_press,
            R.drawable.ic_home_read_press, R.drawable.ic_home_mine_press};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_home;
    }


    @Override
    protected int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void init() {
        super.init();
//        StatusBarUtils.setLightMode(this);
//        StatusBarUtils.setColor(this, getResources().getColor(R.color.main_black));

        StateAppBar.setStatusBarColor(this, ContextCompat.getColor(this, R.color.main_black));

        Fragment paperFragment = RouterConfig.getFragment(RouterUrl.Paper.FRAGMENT_PAPER);
        Fragment movieFragment = RouterConfig.getFragment(RouterUrl.Movie.FRAGMENT_MOVIE);
        Fragment readFragment = RouterConfig.getFragment(RouterUrl.Read.FRAGMENT_READ);
        Fragment mineFragment = RouterConfig.getFragment(RouterUrl.Mine.FRAGMENT_MINE);

        mFragments.add(paperFragment);
        mFragments.add(movieFragment);
        mFragments.add(readFragment);
        mFragments.add(mineFragment);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mBinding.tabLayout.setTabData(mTabEntities, this, R.id.frame_layout, mFragments);

    }


}
