package com.sanerly.movie.viewmodel;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.common.api.Api;
import com.sanerly.base.basic.BaseViewModel;
import com.sanerly.base.util.ToastUtils;
import com.sanerly.movie.model.MovieApiResult;
import com.sanerly.movie.model.MoviesBean;
import com.sanerly.movie.ui.adapter.MovieListAdapter;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.List;

/**
 * 作者：Sanerly
 * 时间；2019/4/2 16:31
 */
public class MovieListViewModel extends BaseViewModel{

    public ObservableArrayList<ItemViewModel> mList=new ObservableArrayList<>();
    public MovieListAdapter mAdapter=new MovieListAdapter(mList);
    public MovieListViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadData(ObservableField<String> path){

        showDialog();

        EasyHttp.get(path.get())
                .baseUrl(Api.MovieApi.BASE_URL)
                .params("skip",60+"")
                .execute(new CallBackProxy<MovieApiResult<List<MoviesBean>>, List<MoviesBean>>(new SimpleCallBack<List<MoviesBean>>() {
                    @Override
                    public void onError(ApiException e) {
                        dismissDialog();
                        ToastUtils.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(List<MoviesBean> beans) {
                        dismissDialog();
                        for (int i = 0; i < beans.size(); i++) {
                            ItemViewModel model=new ItemViewModel(getApplication());
                            model.setBean(beans.get(i));
                            mList.add(model);
                        }
                    }
                }) {
                });
    }
}
