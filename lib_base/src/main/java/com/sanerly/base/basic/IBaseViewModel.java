package com.sanerly.base.basic;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * 作者：Sanerly
 * 时间；2019/3/16 17:22
 */
public interface IBaseViewModel extends LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
   void onAny(LifecycleOwner owner, Lifecycle.Event event);

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate();

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy();

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart();

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
     void onResume();

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
     void onPause();

    /**
     * 注册RxBus
     */
     void registerRxBus();

    /**
     * 移除RxBus
     */
     void removeRxBus();
}
