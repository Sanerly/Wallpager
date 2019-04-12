package com.sanerly.base.adapter;

import android.view.View;

/**
 * 作者：Sanerly
 * 时间；2019/4/1 10:52
 */
public interface AdapterListener {
    interface onItemClickListener<M>{
        void onItemClick(M m, int position);
    }
    interface onItemLongClickListener<M>{
        void onItemLongClick(M m, int position);
    }
    interface onItemChildClickListener<M>{
        void onItemChildClick(View view,M m,int position);
    }
}
