package com.sanerly.paper.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.arouter.RouterConfig;
import com.common.arouter.RouterUrl;
import com.sanerly.base.basic.BaseFragment;
import com.sanerly.paper.BR;
import com.sanerly.paper.R;
import com.sanerly.paper.databinding.PaFragmentPaperBinding;
import com.sanerly.paper.ui.adapter.PaperTabAdapter;
import com.sanerly.paper.viewmodel.PaperModel;

import java.util.ArrayList;

/**
 * 作者：Sanerly
 * 时间；2019/3/21 11:08
 */
@Route(path = RouterUrl.Paper.FRAGMENT_PAPER)
public class PaperFragment extends BaseFragment<PaFragmentPaperBinding, PaperModel> {


    private String[] mTitles = {"物语", "视觉", "动漫"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.pa_fragment_paper;
    }

    @Override
    public int initVariableId() {
        return BR.paViewModel;
    }


    @Override
    public void init() {
        super.init();
        for (int i = 0; i < mTitles.length; i++) {
            Fragment imageFragment = RouterConfig.getFragmentIndex(RouterUrl.Paper.FRAGMENT_PAPER_IMAGE, i + 1);
            mFragments.add(imageFragment);
        }

        mBinding.viewPager.setAdapter(new PaperTabAdapter(getChildFragmentManager(), mFragments, mTitles));
        mBinding.SegmentTabLayout.setViewPager(mBinding.viewPager);
        mBinding.SegmentTabLayout.setCurrentTab(1);
    }

}
