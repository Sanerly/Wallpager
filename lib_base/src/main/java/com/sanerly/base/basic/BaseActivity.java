package com.sanerly.base.basic;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.lxj.xpopup.XPopup;
import com.sanerly.base.R;
import com.sanerly.base.util.LogUtils;
import com.sanerly.base.util.StatusBarUtils;
import com.sanerly.base.util.StringUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * 作者：Sanerly
 * 时间；2019/3/16 16:51
 * UI Activity 基类
 */
public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends RxAppCompatActivity implements IBase {

    protected V mBinding;
    protected VM mViewModel;
    private int mViewModelId;
    private XPopup mXPopup;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //页面接受的参数方法
        initParam();
        //私有的初始化Databinding和ViewModel方法
        initViewDataBinding(savedInstanceState);
        //私有的ViewModel与View的契约事件回调逻辑
        registorLiveDataCallBack();
        //初始化
        init();
        //加载数据
        loadData();
        //初始化界面观察者的监听
        initViewObservable();
        mViewModel.registerRxBus();
    }


    /**
     * 注入绑定
     */
    private void initViewDataBinding(Bundle savedInstanceState) {
        //DataBindingUtil类需要在project的build中配置 dataBinding {enabled true }, 同步后会自动关联android.databinding包
        mBinding = DataBindingUtil.setContentView(this, initContentView(savedInstanceState));
        mViewModelId = initVariableId();
        mViewModel = initViewModel();
        if (mViewModel == null) {
            Class modelClass;
            //使用反射获取
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) createViewModel(this, modelClass);
        }
        //关联ViewModel
        mBinding.setVariable(mViewModelId, mViewModel);
        //让ViewModel拥有View的生命周期感应
        getLifecycle().addObserver(mViewModel);
        //注入RxLifecycle生命周期
        mViewModel.setRxLifecycle(this);
        //注入Activity
        mViewModel.setActivity(this);

    }


    /**
     * 刷新布局
     */
    public void onRefreshLayout() {
        if (mViewModel != null) {
            mBinding.setVariable(mViewModelId, mViewModel);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除ViewModel生命周期感应
        getLifecycle().removeObserver(mViewModel);
        if (mViewModel != null) {
            mViewModel.removeRxBus();
        }
        if (mBinding != null) {
            mBinding.unbind();
        }
    }

    /**
     * 私有的ViewModel与View的契约事件回调逻辑
     */
    private void registorLiveDataCallBack() {
        mViewModel.getLiveData().getShowDialogEvent().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                showLoadDialog(s);
            }
        });

        mViewModel.getLiveData().getDismissDialogEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                dismissLoadDialog();
            }
        });

        mViewModel.getLiveData().getFinishEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                onBackPressed();
            }
        });
    }

    //注册加载框
    private void showLoadDialog(String title) {
        mXPopup = XPopup.get(this);
        if (StringUtils.isTrimEmpty(title)) {
            mXPopup.asLoading();
        } else {
            mXPopup.asLoading(title);
        }
        mXPopup.dismissOnTouchOutside(false).dismissOnBackPressed(false).show();
    }

    private void dismissLoadDialog() {
        if (mXPopup != null) {
            mXPopup.dismiss();
        }
    }


    /**
     * 初始化布局
     *
     * @return 布局layout的id
     */
    protected abstract int initContentView(Bundle savedInstanceState);


    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    protected abstract int initVariableId();


    /**
     * 初始化ViewModel
     *
     * @return 继承BaseViewModel的ViewModel
     */
    public VM initViewModel() {
        return null;
    }


    @Override
    public void initParam() {

    }

    @Override
    public void init() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initViewObservable() {

    }

    /**
     * 创建ViewModel
     */
    public <T extends ViewModel> T createViewModel(FragmentActivity activity, Class<T> cls) {
        return ViewModelProviders.of(activity).get(cls);
    }
}
