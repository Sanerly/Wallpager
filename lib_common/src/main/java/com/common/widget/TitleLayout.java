package com.common.widget;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.common.BR;
import com.common.R;
import com.common.databinding.TitleLayoutBinding;
import com.sanerly.base.basic.BaseViewModel;

/**
 * 作者：Sanerly
 * 时间；2019/3/25 11:06
 */
public class TitleLayout extends FrameLayout {
    private TitleLayoutBinding mBinding;
    private OnLeftListener mLeftListener;

    public TitleLayout(@NonNull Context context) {
        this(context, null);
    }

    public TitleLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.title_layout, this, true);
        mBinding.titleIvLeft.setOnClickListener(mLeftClickListener);
    }

    public TitleLayout setTitle(@StringRes int resid) {
        mBinding.titleTvText.setText(resid);
        return this;
    }

    public TitleLayout setTitle(CharSequence text) {
        mBinding.titleTvText.setText(text);
        return this;
    }

    public String getTitle() {
        return mBinding.titleTvText.getText().toString();

    }

    public TitleLayout setTitleColor(@ColorRes int id) {
        mBinding.titleTvText.setTextColor(getContext().getResources().getColor(id));
        return this;
    }

    public TitleLayout setBgResource(@DrawableRes int resid) {
        mBinding.titleLayout.setBackgroundResource(resid);
        return this;
    }

    public TitleLayout setBgTransparent() {
        mBinding.titleLayout.setBackgroundColor(Color.TRANSPARENT);
        return this;
    }

    public TitleLayout setLeftResource(@DrawableRes int resid) {
        mBinding.titleIvLeft.setImageResource(resid);
        return this;
    }

    public void setLeftVisibility(int visibility) {
        mBinding.titleIvLeft.setVisibility(visibility);
    }

    public TitleLayout setLeftListener(OnLeftListener leftListener) {
        mLeftListener = leftListener;
        return this;
    }

    public FrameLayout getTitleLayout() {
        return mBinding.titleLayout;
    }

    public interface OnLeftListener {
        void onLeft();
    }

    private OnClickListener mLeftClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mLeftListener != null) {
                mLeftListener.onLeft();
            } else {
                if (getContext() instanceof Activity) {
                    ((Activity) getContext()).onBackPressed();
                }
            }
        }
    };
}
