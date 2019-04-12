package com.common.widget.viewpager2.adapter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

/**
 * 作者：Sanerly
 * 时间；2019/4/4 11:56
 */
public interface LifecycleEventObserver extends LifecycleObserver {
    /**
     * Called when a state transition event happens.
     *
     * @param source The source of the event
     * @param event The event
     */
    void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event);
}
