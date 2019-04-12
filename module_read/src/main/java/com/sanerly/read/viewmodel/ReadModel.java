package com.sanerly.read.viewmodel;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;

import com.sanerly.base.basic.BaseViewModel;
import com.sanerly.read.ui.apapter.ReadAdapter;

/**
 * 作者：Sanerly
 * 时间；2019/3/25 15:32
 */
public class ReadModel extends BaseViewModel {
    private ObservableArrayList<ItemViewModel> mList = new ObservableArrayList<>();
    public ReadAdapter readAdapter = new ReadAdapter(mList);

    public ReadModel(@NonNull Application application) {
        super(application);
    }


    public void loadData() {
        for (int i = 0; i < 20; i++) {
            ItemViewModel model = new ItemViewModel(getApplication());
            mList.add(model);
        }
    }
}
