package com.sanerly.read.ui.apapter;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.common.widget.viewpager2.adapter.FragmentStateAdapter;

/**
 * 作者：Sanerly
 * 时间；2019/4/4 14:19
 */
public class ReadPagerAdapter extends FragmentStateAdapter{

    public ReadPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
