package com.oleeja.soccerinfo.presentation.common;

import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Oleja on 27.01.2018.
 */

public abstract class BindingAdapter<T extends ViewDataBinding> extends Adapter<BindingViewHolder<T>> {
    private static final Object PAYLOAD = new Object();
    @Nullable
    private RecyclerView mRecyclerView;
    private final OnRebindCallback mPreBindCallback = new OnRebindCallback() {
        public boolean onPreBind(ViewDataBinding binding) {
            if (BindingAdapter.this.mRecyclerView != null && !BindingAdapter.this.mRecyclerView.isComputingLayout()) {
                int adapterPosition = BindingAdapter.this.mRecyclerView.getChildAdapterPosition(binding.getRoot());
                if (adapterPosition == -1) {
                    return true;
                } else {
                    BindingAdapter.this.notifyItemChanged(adapterPosition, BindingAdapter.PAYLOAD);
                    return false;
                }
            } else {
                return true;
            }
        }
    };

    public BindingAdapter() {
    }

    @CallSuper
    public BindingViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        BindingViewHolder<T> viewHolder = BindingViewHolder.create(parent, viewType);
        viewHolder.binding.addOnRebindCallback(this.mPreBindCallback);
        return viewHolder;
    }

    public final void onBindViewHolder(BindingViewHolder<T> holder, int position) {
        this.onBindViewHolder(holder, position, Collections.emptyList());
    }

    public final void onBindViewHolder(BindingViewHolder<T> holder, int position, List<Object> payloads) {
        if (payloads.isEmpty() || this.hasNonDataBindingInvalidate(payloads)) {
            this.bindItem(holder, position, payloads);
        }

        holder.binding.executePendingBindings();
    }

    private boolean hasNonDataBindingInvalidate(List<Object> payloads) {
        Iterator var2 = payloads.iterator();

        Object payload;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            payload = var2.next();
        } while (payload == PAYLOAD);

        return true;
    }

    protected abstract void bindItem(BindingViewHolder<T> var1, int var2, List<Object> var3);

    public final int getItemViewType(int position) {
        return this.getLayoutId(position);
    }

    @LayoutRes
    protected abstract int getLayoutId(int var1);

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRecyclerView = null;
    }

}
