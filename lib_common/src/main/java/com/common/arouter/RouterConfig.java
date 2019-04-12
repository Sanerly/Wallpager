package com.common.arouter;

import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sanerly.base.util.LogUtils;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 作者：Sanerly
 * 时间：2019/3/7
 * 描述：注册路由初始化
 */
public class RouterConfig {

    /**
     * 作者：Sanerly
     * 时间：2018/10/10
     * 描述：初始化路由
     */
    public static void init(Application application, boolean isDebug) {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (isDebug) {
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(application);
    }


    public static Fragment getFragment(String path) {
        return getFragment(path, null);
    }


    public static Fragment getFragment(String path, Bundle bundle) {

        return (Fragment) ARouter.getInstance().build(path).with(bundle).navigation();
    }


    public static Fragment getFragmentIndex(String path, int index) {
        return (Fragment) ARouter.getInstance().build(path).withInt("index",index).navigation();
    }


    public static void toActivity(String path){
        ARouter.getInstance().build(path).navigation();
    }

}
