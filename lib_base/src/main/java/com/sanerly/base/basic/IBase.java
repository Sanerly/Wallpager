package com.sanerly.base.basic;

/**
 * 作者：Sanerly
 * 时间；2019/3/16 17:48
 */
public interface IBase {
    /**
     * 初始化界面传递参数
     */
    void initParam();
    /**
     * 初始化
     */
    void init();

    /**
     * 加载数据
     */
    void loadData();

    /**
     * 初始化界面观察者的监听
     */
    void initViewObservable();
}
