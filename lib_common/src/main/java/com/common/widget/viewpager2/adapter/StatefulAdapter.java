package com.common.widget.viewpager2.adapter;

import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * 作者：Sanerly
 * 时间；2019/4/4 11:15
 */
public interface StatefulAdapter {

    /** Saves adapter state */
    @NonNull Parcelable saveState();
    /** Restores adapter state */
    void restoreState(@NonNull Parcelable savedState);
}
