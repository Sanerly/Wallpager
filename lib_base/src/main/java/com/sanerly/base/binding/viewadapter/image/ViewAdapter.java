package com.sanerly.base.binding.viewadapter.image;


import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

/**
*作者：Sanerly
*时间：2019/3/30
*描述：圖片
*/
public final class ViewAdapter {

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int resId) {
        view.setImageResource(resId);
    }

    @BindingAdapter(value = {"imageUrl","thumbUrl"},requireAll  =false)
    public static void loadImage(ImageView imageView, String url,String thumb) {
        Glide.with(imageView.getContext())
                .load(url)
                .thumbnail(Glide.with(imageView.getContext()).load(thumb))
                .into(imageView);
    }
}

