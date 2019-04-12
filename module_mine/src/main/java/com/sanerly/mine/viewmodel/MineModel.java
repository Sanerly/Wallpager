package com.sanerly.mine.viewmodel;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.sanerly.base.basic.BaseViewModel;
import com.sanerly.mine.ui.adapter.MineAdapter;

/**
 * 作者：Sanerly
 * 时间；2019/4/4 17:33
 */
public class MineModel extends BaseViewModel{

    public ObservableField<String> mAvater=new ObservableField<>();
    private ObservableArrayList<ItemViewModel> mList=new ObservableArrayList<>();
    public MineAdapter mAdapter=new MineAdapter(mList);
    private String [] mArray={"自定义View","动画","音视频从入门到提高"};
    public MineModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAvater.set("http://img5.adesk.com/5c3d5850e7bce75ea7b3002b?imageMogr2/thumbnail/!350x540r/gravity/Center/crop/350x540");

    }

    public void loadData(){
        for (int i = 0; i < mArray.length; i++) {
            ItemViewModel itemViewModel=new ItemViewModel(getApplication());
            itemViewModel.getLabel().set(mArray[i]);
            mList.add(itemViewModel);
        }
    };

}
