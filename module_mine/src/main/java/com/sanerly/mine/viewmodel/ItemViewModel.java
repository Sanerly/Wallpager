package com.sanerly.mine.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.sanerly.base.basic.BaseViewModel;

/**
 * 作者：Sanerly
 * 时间；2019/4/8 10:10
 */
public class ItemViewModel extends BaseViewModel{
    public ObservableField<String> mLabel=new ObservableField<>();
    public ItemViewModel(@NonNull Application application) {
        super(application);
    }

    public void setLabel(ObservableField<String> label) {
        mLabel = label;
    }

    public ObservableField<String> getLabel() {
        return mLabel;
    }
}
