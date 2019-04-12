package com.sanerly.read.ui.apapter;

import android.databinding.ObservableArrayList;

import com.sanerly.base.adapter.BaseBindingAdapter;
import com.sanerly.read.R;
import com.sanerly.read.databinding.RdItemReadLayoutBinding;
import com.sanerly.read.viewmodel.ItemViewModel;

/**
 * 作者：Sanerly
 * 时间；2019/4/4 10:30
 */
public class ReadAdapter extends BaseBindingAdapter<ItemViewModel,RdItemReadLayoutBinding>{

    public ReadAdapter(ObservableArrayList<ItemViewModel> datas) {
        super(datas);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.rd_item_read_layout;
    }

    @Override
    protected void onBindItem(RdItemReadLayoutBinding binding, ItemViewModel item, int position) {
        binding.setItemViewModel(item);
    }
}
