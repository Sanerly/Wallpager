package com.sanerly.base.basic;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

import com.sanerly.base.bus.event.SingleLiveEvent;

import com.sanerly.base.bus.event.SnackbarMessage;
import com.sanerly.base.util.LogUtils;
import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * 作者：Sanerly
 * 时间；2019/3/16 17:40
 */
public class BaseViewModel extends AndroidViewModel implements IBaseViewModel {

    private LifecycleProvider lifecycle;
    private UIChangeLiveData mLiveData;
    public BaseViewModel(@NonNull Application application) {
        super(application);
    }


    public LifecycleProvider getRxLifecycle() {
        return lifecycle;
    }

    public BaseViewModel setRxLifecycle(LifecycleProvider lifecycle) {
        this.lifecycle = lifecycle;
        return this;
    }



    public BaseViewModel getContext() {
        return this;
    }

    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {

    }

    @Override
    public void registerRxBus() {

    }

    @Override
    public void removeRxBus() {

    }


    public void finish() {
        mLiveData.finishEvent.call();
    }

    public void showDialog() {
        showDialog(null);
    }

    public void showDialog(String title) {
        mLiveData.showDialogEvent.postValue(title);
    }

    public void dismissDialog() {
        mLiveData.dismissDialogEvent.call();
    }


    public UIChangeLiveData getLiveData() {
        if (mLiveData == null) {
            mLiveData = new UIChangeLiveData();
        }
        return mLiveData;
    }

    public final class UIChangeLiveData extends SingleLiveEvent {
        private SingleLiveEvent<String> showDialogEvent;
        private SingleLiveEvent<Void> dismissDialogEvent;
        private SingleLiveEvent<Void> finishEvent;

        public SingleLiveEvent<String> getShowDialogEvent() {
            return showDialogEvent = createLiveData(showDialogEvent);
        }


        public SingleLiveEvent<Void> getDismissDialogEvent() {
            return dismissDialogEvent = createLiveData(dismissDialogEvent);
        }

        public SingleLiveEvent<Void> getFinishEvent() {
            return finishEvent = createLiveData(finishEvent);
        }

        private SingleLiveEvent createLiveData(SingleLiveEvent liveData) {
            if (liveData == null) {
                liveData = new SingleLiveEvent();
            }
            return liveData;
        }

    }
}
