package com.sanerly.paper.ui.fragment;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.api.Api;
import com.common.arouter.RouterUrl;
import com.common.util.FUtils;
import com.sanerly.base.basic.BaseFragment;
import com.sanerly.paper.BR;
import com.sanerly.paper.R;
import com.sanerly.paper.databinding.PaFragmentNewBinding;
import com.sanerly.paper.viewmodel.ImageModel;

/**
 * 作者：Sanerly
 * 时间；2019/3/25 16:46
 */
@Route(path = RouterUrl.Paper.FRAGMENT_PAPER_IMAGE)
public class ImageFragment extends BaseFragment<PaFragmentNewBinding, ImageModel> {
    private int mIndex;
    private ObservableField<String> mPath=new ObservableField<>();

    @Override
    protected int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.pa_fragment_new;
    }

    @Override
    public int initVariableId() {
        return BR.newViewModel;
    }

    @Override
    public void initParam() {
        super.initParam();
        mIndex = FUtils.getFragmentIndex(this, "index");
        if (mIndex==1){
            mPath.set( Api.PaperApi.PAPER_HOT);
        }else if (mIndex==2){
            mPath.set(Api.PaperApi.PAPER_NEW);
        }else {
            mPath.set(Api.PaperApi.PAPER_ANIME);
        }
    }


    @Override
    public void loadData() {
        super.loadData();
        mViewModel.loadData(mPath);
    }
}
