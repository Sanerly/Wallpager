package com.sanerly.base.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.sanerly.base.basic.AppManager;
import com.sanerly.base.util.FontsUtils;
import com.sanerly.base.util.LogUtils;
import com.sanerly.base.util.Utils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;

/**
 * 作者：Sanerly
 * 时间；2019/3/7 17:19
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setApplication(this);
    }

    /**
     * 初始化
     */
    public static synchronized void setApplication(Application app) {
        //初始化log打印
        LogUtils.init();
        //设置全局上下文
        Utils.init(app);
        //注册监听每个activity的生命周期,便于堆栈式管理
        registerActivityLifecycle(app);
        //初始化网络框架
        initEasyHttp(app);
        //设置默认中文字体
        FontsUtils.initDefault();
    }

    /**
     * 堆栈式管理
     */
    private static void registerActivityLifecycle(Application application) {
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                AppManager.getAppManager().addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                AppManager.getAppManager().removeActivity(activity);
            }
        });
    }


    private static void initEasyHttp(Application app){
        //初始化网络请求
        EasyHttp.init(app);//默认初始化,必须调用
        //以下设置的所有参数是全局参数,同样的参数可以在请求的时候再设置一遍,那么对于该请求来讲,请求中的参数会覆盖全局参数
        EasyHttp.getInstance()
                // 打开该调试开关并设置TAG,不需要就不要加入该行
                // 最后的true表示是否打印内部异常，一般打开方便调试错误
                .debug("EasyHttp", true)
                //如果使用默认的60秒,以下三行也不需要设置
                .setReadTimeOut(60 * 1000)
                .setWriteTimeOut(60 * 100)
                .setConnectTimeout(60 * 100)
                //可以全局统一设置超时重连次数,默认为3次,那么最差的情况会请求4次(一次原始请求,三次重连请求),
                //不需要可以设置为0
                .setRetryCount(3)//网络不好自动重试3次
                //可以全局统一设置超时重试间隔时间,默认为500ms,不需要可以设置为0
                .setRetryDelay(500)//每次延时500ms重试
                //可以全局统一设置超时重试间隔叠加时间,默认为0ms不叠加
                .setRetryIncreaseDelay(500);//每次延时叠加500ms

    };
}
