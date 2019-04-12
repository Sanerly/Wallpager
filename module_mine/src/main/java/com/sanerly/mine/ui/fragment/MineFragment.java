package com.sanerly.mine.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.arouter.RouterConfig;
import com.common.arouter.RouterUrl;
import com.sanerly.base.adapter.AdapterListener;
import com.sanerly.base.basic.BaseFragment;
import com.sanerly.base.util.LogUtils;
import com.sanerly.mine.BR;
import com.sanerly.mine.R;
import com.sanerly.mine.databinding.MeFragmentMineBinding;
import com.sanerly.mine.viewmodel.MineModel;

/**
 * 作者：Sanerly
 * 时间；2019/3/21 14:22
 */
@Route(path = RouterUrl.Mine.FRAGMENT_MINE)
public class MineFragment extends BaseFragment<MeFragmentMineBinding, MineModel> {
    @Override
    protected int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.me_fragment_mine;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void loadData() {
        super.loadData();
        mViewModel.loadData();
        mBinding.titleLayout.setTitle("我").setLeftVisibility(View.GONE);
        mViewModel.mAdapter.setOnItemClickListener(new AdapterListener.onItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        LogUtils.e("position = "+position);
                        RouterConfig.toActivity(RouterUrl.AV.ACTIVITY_AUDIO);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
