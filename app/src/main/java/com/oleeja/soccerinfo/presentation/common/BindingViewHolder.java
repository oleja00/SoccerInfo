package com.oleeja.soccerinfo.presentation.common;



import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Oleja on 27.01.2018.
 */

public class BindingViewHolder<T extends ViewDataBinding> extends ViewHolder {
    protected T binding;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public T getBinding() {
        return this.binding;
    }

    public static <T extends ViewDataBinding> BindingViewHolder<T> create(ViewGroup parent, @LayoutRes int layoutId) {
        T binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false);
        return new BindingViewHolder(binding);
    }
}

