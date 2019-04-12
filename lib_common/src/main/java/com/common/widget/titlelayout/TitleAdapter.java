package com.common.widget.titlelayout;

import android.databinding.BindingAdapter;

import com.common.widget.TitleLayout;

/**
 * 作者：Sanerly
 * 时间；2019/4/8 15:03
 */
public class TitleAdapter {

    @BindingAdapter(value = {"setTitle"}, requireAll = false)
    public static void setTitle(TitleLayout titleLayout, String title) {
        if (title == null) {
            return;
        }
        titleLayout.setTitle(title);
    }
}
