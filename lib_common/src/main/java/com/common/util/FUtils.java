package com.common.util;

import android.support.v4.app.Fragment;

/**
 * 作者：Sanerly
 * 时间；2019/3/26 9:57
 */
public class FUtils {

    /**
     * 获取Fragment 的Index
     */
    public static int getFragmentIndex(Fragment fragment, String key) {
        if (fragment.getArguments() != null) {
            return fragment.getArguments().getInt(key,-1);
        }
        return -1;
    }
}
