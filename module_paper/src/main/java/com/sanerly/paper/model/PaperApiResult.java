package com.sanerly.paper.model;

import com.zhouyou.http.model.ApiResult;

/**
 * 作者：Sanerly
 * 时间；2019/3/27 15:58
 */
public class PaperApiResult<T> extends ApiResult<T>{

    T res;

    @Override
    public T getData() {

        return res;
    }


}
