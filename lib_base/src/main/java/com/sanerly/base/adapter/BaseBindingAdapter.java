package com.sanerly.base.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sanerly.base.basic.BaseViewModel;

/**
 * 作者：Sanerly
 * 时间；2019/3/30 18:13
 */
public abstract class BaseBindingAdapter<M extends BaseViewModel, B extends ViewDataBinding> extends RecyclerView.Adapter {
    protected Context mContext;
    private ObservableArrayList<M> mDatas;
    private ListChangedCallback itemsChangeCallback;
    protected AdapterListener.onItemChildClickListener mItemChildClickListener;
    private AdapterListener.onItemClickListener mItemClickListener;
    private AdapterListener.onItemLongClickListener mItemLongClickListener;
    public BaseBindingAdapter(ObservableArrayList<M> datas) {
        this.mDatas = datas;
        this.itemsChangeCallback = new ListChangedCallback();
    }

    @Override
    public int getItemCount() {
        return this.mDatas.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();

        B binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), this.getLayoutResId(viewType), parent, false);
        return new BaseBindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final B binding = DataBindingUtil.getBinding(holder.itemView);
        this.onBindItem(binding, this.mDatas.get(position),position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(mDatas.get(position), position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mItemLongClickListener != null) {
                    mItemLongClickListener.onItemLongClick(mDatas.get(position), position);
                }
                return true;
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mDatas.addOnListChangedCallback(itemsChangeCallback);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mDatas.removeOnListChangedCallback(itemsChangeCallback);
    }

    /**
     * region 处理数据集变化
     */
    private void onChanged(ObservableArrayList<M> newItems) {
        reset(newItems);
        notifyDataSetChanged();
    }

    private void onItemRangeChanged(ObservableArrayList<M> newItems, int positionStart, int itemCount) {
        reset(newItems);
        notifyItemRangeChanged(positionStart, itemCount);
    }

    private void onItemRangeInserted(ObservableArrayList<M> newItems, int positionStart, int itemCount) {
        reset(newItems);
        notifyItemRangeInserted(positionStart, itemCount);
    }

    private void onItemRangeMoved(ObservableArrayList<M> newItems) {
        reset(newItems);
        notifyDataSetChanged();
    }

    private void onItemRangeRemoved(ObservableArrayList<M> newItems, int positionStart, int itemCount) {
        reset(newItems);
        notifyItemRangeRemoved(positionStart, itemCount);
    }


    private class BaseBindingViewHolder extends RecyclerView.ViewHolder {
        BaseBindingViewHolder(View itemView) {
            super(itemView);
        }
    }

    private void reset(ObservableArrayList<M> datas) {
        this.mDatas = datas;
    }

    @LayoutRes
    protected abstract int getLayoutResId(int viewType);

    protected abstract void onBindItem(B binding, M item,int position);

    private class ListChangedCallback extends ObservableArrayList.OnListChangedCallback<ObservableArrayList<M>> {
        @Override
        public void onChanged(ObservableArrayList<M> newItems) {
            BaseBindingAdapter.this.onChanged(newItems);
        }

        @Override
        public void onItemRangeChanged(ObservableArrayList<M> newItems, int i, int i1) {
            BaseBindingAdapter.this.onItemRangeChanged(newItems, i, i1);
        }

        @Override
        public void onItemRangeInserted(ObservableArrayList<M> newItems, int i, int i1) {
            BaseBindingAdapter.this.onItemRangeInserted(newItems, i, i1);
        }

        @Override
        public void onItemRangeMoved(ObservableArrayList<M> newItems, int i, int i1, int i2) {
            BaseBindingAdapter.this.onItemRangeMoved(newItems);
        }

        @Override
        public void onItemRangeRemoved(ObservableArrayList<M> sender, int positionStart, int itemCount) {
            BaseBindingAdapter.this.onItemRangeRemoved(sender, positionStart, itemCount);
        }
    }

    /**
     * 设置Item长按事件
     */
    public void setOnItemLongClickListener(AdapterListener.onItemLongClickListener listener) {
        this.mItemLongClickListener = listener;
    }

    /**
     * 设置单击事件
     */
    public void setOnItemClickListener(AdapterListener.onItemClickListener listener) {
        this.mItemClickListener = listener;
    }


    /**
     * 设置子控件点击事件
     */
    public void setOnItemChildClickListener(AdapterListener.onItemChildClickListener listener) {
        this.mItemChildClickListener = listener;
    }


    /**
     * 获取数据集合
     */
    public ObservableArrayList<M> getDatas() {
        return mDatas;
    }
}
