package com.common.imageloader;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

/**
 * 作者：Sanerly
 * 时间；2019/3/29 14:57
 */
public class GildeLoader {
    public static void loader(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .apply(new RequestOptions().override(Target.SIZE_ORIGINAL))
                .into(view);
    }
}
