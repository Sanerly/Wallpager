package com.sanerly.paper.viewmodel;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.common.api.Api;
import com.common.widget.xp.ImageLoader;
import com.lxj.xpopup.XPopup;
import com.sanerly.base.adapter.AdapterListener;
import com.sanerly.base.basic.BaseViewModel;
import com.sanerly.base.util.ToastUtils;
import com.sanerly.paper.model.PaperApiResult;
import com.sanerly.paper.model.ResBean;
import com.sanerly.paper.model.VerticalBean;
import com.sanerly.paper.ui.adapter.ImageAdapter;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.ApiResult;

import java.util.List;

/**
 * 作者：Sanerly
 * 时间；2019/3/26 10:56
 */
public class ImageModel extends BaseViewModel {

    //给RecyclerView添加ObservableList
    private ObservableArrayList<ImageItemViewModel> observableList = new ObservableArrayList<>();
    public ImageAdapter adapter = new ImageAdapter(observableList);

    public ImageModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        adapter.setOnItemChildClickListener(new AdapterListener.onItemChildClickListener<ImageItemViewModel>() {

            @Override
            public void onItemChildClick(View view, ImageItemViewModel imageItemViewModel, int position) {
                XPopup.get(view.getContext())
                        .asImageViewer((ImageView) view, imageItemViewModel.mUrl.get(), new ImageLoader())
                        .show();
            }
        });

    }

    public void loadData(ObservableField<String> path) {
        showDialog();
        observableList.clear();

        EasyHttp.get(path.get())
                .baseUrl(Api.PaperApi.BASE_URL)
                .params("skip",60+"")
                .execute(new CallBackProxy<PaperApiResult<ResBean>, ResBean>(new SimpleCallBack<ResBean>() {
                    @Override
                    public void onError(ApiException e) {
                        dismissDialog();
                        ToastUtils.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(ResBean res) {
                        dismissDialog();
                        for (int i = 0; i < res.getVertical().size(); i++) {
                            ImageItemViewModel model = new ImageItemViewModel(getApplication());
                            model.setUrl(res.getVertical().get(i).getImg());
                            model.setThumbUrl(res.getVertical().get(i).getThumb());
                            observableList.add(model);
                        }
                    }
                }) {
                });



    }

}
