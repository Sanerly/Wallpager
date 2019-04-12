package com.sanerly.mine.ui.adapter;


import android.databinding.ObservableArrayList;

import com.sanerly.base.adapter.BaseBindingAdapter;
import com.sanerly.mine.R;
import com.sanerly.mine.databinding.MeItemMineLayoutBinding;
import com.sanerly.mine.viewmodel.ItemViewModel;

/**
 * 作者：Sanerly
 * 时间；2019/4/8 10:10
 */
public class MineAdapter extends BaseBindingAdapter<ItemViewModel,MeItemMineLayoutBinding>{
    public MineAdapter(ObservableArrayList<ItemViewModel> datas) {
        super(datas);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.me_item_mine_layout;
    }

    @Override
    protected void onBindItem(MeItemMineLayoutBinding binding, ItemViewModel item, int position) {
        binding.setItemViewModel(item);
    }




}
