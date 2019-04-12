package com.sanerly.movie.model;

import com.zhouyou.http.model.ApiResult;

/**
 * 作者：Sanerly
 * 时间；2019/3/27 15:58
 */
public class MovieApiResult<T> extends ApiResult<T>{

    T movies;

    @Override
    public boolean isOk() {
        return true;
    }

    @Override
    public T getData() {

        return movies;
    }
}
