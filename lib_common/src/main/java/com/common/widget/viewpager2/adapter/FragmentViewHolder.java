package com.common.widget.viewpager2.adapter;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * 作者：Sanerly
 * 时间；2019/4/4 11:16
 */

/**
 * {@link android.support.v7.widget.RecyclerView.ViewHolder} implementation for handling {@link android.support.v4.app.Fragment}s. Used in
 * {@link FragmentStateAdapter}.
 */
public class FragmentViewHolder extends RecyclerView.ViewHolder {
    private FragmentViewHolder(FrameLayout container) {
        super(container);
    }
    static FragmentViewHolder create(ViewGroup parent) {
        FrameLayout container = new FrameLayout(parent.getContext());
        container.setLayoutParams(
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
        container.setId(ViewCompat.generateViewId());
        container.setSaveEnabled(false);
        return new FragmentViewHolder(container);
    }
    FrameLayout getContainer() {
        return (FrameLayout) itemView;
    }
}
