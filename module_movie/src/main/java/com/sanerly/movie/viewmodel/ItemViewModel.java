package com.sanerly.movie.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.sanerly.base.basic.BaseViewModel;
import com.sanerly.movie.model.MoviesBean;

/**
 * 作者：Sanerly
 * 时间；2019/4/3 10:13
 */
public class ItemViewModel extends BaseViewModel {
    public MoviesBean mBean;

    public ItemViewModel(@NonNull Application application) {
        super(application);
    }

    public void setBean(MoviesBean bean) {
        mBean = bean;
    }
}
