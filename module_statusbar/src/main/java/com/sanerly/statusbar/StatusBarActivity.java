package com.sanerly.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.arouter.RouterUrl;
import com.sanerly.base.basic.BaseActivity;
import com.sanerly.base.util.StatusBarUtils;

/**
 * 作者：Sanerly
 * 时间：2019/4/17 15:23
 */
@Route(path = RouterUrl.Status.ACTIVITY_STATUS)
public class StatusBarActivity extends BaseActivity{
    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.status_bar_activity;
    }

    @Override
    protected int initVariableId() {
        return 0;
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
//    }

    @Override
    public void init() {
        super.init();

        StatusBarUtils.setColor(this, getResources().getColor(R.color.black));
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(Color.RED);
//        }
    }
}
