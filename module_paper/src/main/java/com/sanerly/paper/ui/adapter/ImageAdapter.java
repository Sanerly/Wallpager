package com.sanerly.paper.ui.adapter;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.view.View;

import com.sanerly.base.adapter.BaseBindingAdapter;
import com.sanerly.paper.R;
import com.sanerly.paper.databinding.PaItemImageLayoutBinding;
import com.sanerly.paper.viewmodel.ImageItemViewModel;

/**
 * 作者：Sanerly
 * 时间；2019/3/30 17:23
 * PaItemImageLayoutBinding binding= DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.pa_item_image_layout,viewGroup,true);
 */
public class ImageAdapter extends BaseBindingAdapter<ImageItemViewModel, PaItemImageLayoutBinding> {


    public ImageAdapter( ObservableArrayList<ImageItemViewModel> datas) {
        super(datas);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.pa_item_image_layout;
    }

    @Override
    protected void onBindItem(PaItemImageLayoutBinding binding, final ImageItemViewModel item, final int position) {
        binding.setImageItemViewModel(item);
        binding.ivItemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemChildClickListener != null) {
                    mItemChildClickListener.onItemChildClick(v, item,position);
                }
            }
        });
    }


}
