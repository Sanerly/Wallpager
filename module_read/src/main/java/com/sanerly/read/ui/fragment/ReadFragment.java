package com.sanerly.read.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.arouter.RouterUrl;
import com.common.widget.DLinearLayoutManager;
import com.common.widget.viewpager2.view.ViewPager2;
import com.sanerly.base.basic.BaseFragment;
import com.sanerly.base.util.LogUtils;
import com.sanerly.read.BR;
import com.sanerly.read.R;
import com.sanerly.read.databinding.RdFragmentReadBinding;
import com.sanerly.read.ui.apapter.ReadAdapter;
import com.sanerly.read.viewmodel.ReadModel;

/**
 * 作者：Sanerly
 * 时间；2019/3/21 11:48
 */
@Route(path = RouterUrl.Read.FRAGMENT_READ)
public class ReadFragment extends BaseFragment<RdFragmentReadBinding, ReadModel> {
    @Override
    protected int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.rd_fragment_read;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    private int mPosition=0;
    private int mDelaye=1000;
    private Handler mHandler;
    @Override
    public void init() {
        super.init();
        mViewModel.loadData();
        mBinding.titleLayout.setTitle("每日一读").setLeftVisibility(View.GONE);
        mBinding.viewPager2.setAdapter(mViewModel.readAdapter);
        mBinding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mPosition=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

//        mHandler=new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(Message msg) {
//                if (mPosition<mViewModel.readAdapter.getItemCount()-1){
//                    mPosition++;
//                }else {
//                    mPosition=0;
//                }
//                mBinding.viewPager2.setCurrentItem(mPosition);
//
//                mHandler.sendEmptyMessageDelayed(0,mDelaye);
//                return true;
//            }
//        });
//        mHandler.sendEmptyMessageDelayed(0,mDelaye);
    }
}
