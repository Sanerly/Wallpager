package com.sanerly.home.model;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.common.arouter.RouterConfig;
import com.common.arouter.RouterUrl;
import com.common.tab.TabEntity;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.sanerly.base.basic.BaseViewModel;
import com.sanerly.home.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * 作者：Sanerly
 * 时间；2019/3/18 16:32
 */
public class HomeModel extends BaseViewModel{



    public HomeModel(@NonNull Application application) {
        super(application);
    }



    //    public void backOnClickCommand(){
//
//        //RaJava模拟一个延迟操作
//        Observable.just("")
//                .delay(3, TimeUnit.SECONDS) //延迟3秒
//                .compose(getRxLifecycle().bindToLifecycle())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(Disposable disposable) throws Exception {
//                        showDialog();
//                    }
//                })
//                .subscribe(new Consumer() {
//                    @Override
//                    public void accept(Object o) throws Exception {
//                        dismissDialog();
//                        setName("111111");
//                    }
//                });
//    }
}
