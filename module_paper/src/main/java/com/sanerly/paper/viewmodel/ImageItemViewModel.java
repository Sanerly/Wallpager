package com.sanerly.paper.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.sanerly.base.basic.BaseViewModel;

/**
 * 作者：Sanerly
 * 时间；2019/3/28 15:49
 */
public class ImageItemViewModel extends BaseViewModel{
    public ObservableField<String> mUrl = new ObservableField<>();
    public ObservableField<String> mThumbUrl = new ObservableField<>();

    public ImageItemViewModel(@NonNull Application application) {
        super(application);
    }


    public void setUrl(String url) {
        mUrl.set(url);
    }


    public void setThumbUrl(String url) {
        mThumbUrl.set(url);
    }
}
