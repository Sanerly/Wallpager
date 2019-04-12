package com.common.app;

import com.common.arouter.RouterConfig;
import com.sanerly.base.app.BaseApplication;


/**
*作者：Sanerly
*时间：2019/3/7
*描述：基类Applicaation
*/
public class CommonApplication extends BaseApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化路由
        RouterConfig.init(this,true);
    }
}
