package com.sanerly.base.util;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.R;

/**
 * 作者：Sanerly
 * 时间：2019/4/13 15:53
 */
public class FontsUtils {
    public static void  initDefault(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/test1.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
}
