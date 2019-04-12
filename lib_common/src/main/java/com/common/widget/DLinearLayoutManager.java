package com.common.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 作者：Sanerly
 * 时间；2019/4/4 10:51
 */
public class DLinearLayoutManager extends LinearLayoutManager{

    private PagerSnapHelper mPagerSnapHelper;
    public DLinearLayoutManager(Context context) {
        super(context);
        init();
    }



    public DLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        init();
    }

    public DLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPagerSnapHelper=new PagerSnapHelper();
    }

    @Override
    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        mPagerSnapHelper.attachToRecyclerView(view);
    }
}
