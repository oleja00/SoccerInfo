package com.oleeja.soccerinfo.presentation.common;

import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ahmadrosid.svgloader.SvgDecoder;
import com.ahmadrosid.svgloader.SvgDrawableTranscoder;
import com.ahmadrosid.svgloader.SvgSoftwareLayerSetter;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import com.oleeja.soccerinfo.R;

import java.io.InputStream;
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

    @android.databinding.BindingAdapter({"onRefresh"})
    public static void refresh(SwipeRefreshLayout srl, SwipeRefreshLayout.OnRefreshListener listener) {
        srl.setOnRefreshListener(listener);
    }

    @android.databinding.BindingAdapter({"imageUri"})
    public static void setImage(ImageView imageView, String uri) {

        if(uri.endsWith(imageView.getContext().getResources().getString(R.string.svg_resorurce))){
            GenericRequestBuilder<Uri,InputStream,SVG,PictureDrawable> requestBuilder = Glide.with(imageView.getContext())
                    .using(Glide.buildStreamModelLoader(Uri.class, imageView.getContext()), InputStream.class)
                    .from(Uri.class)
                    .as(SVG.class)
                    .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                    .sourceEncoder(new StreamEncoder())
                    .cacheDecoder(new FileToStreamDecoder<>(new SvgDecoder()))
                    .decoder(new SvgDecoder())
                    .placeholder(R.mipmap.ic_loading)
                    .error(R.mipmap.ic_error)
                    .listener(new SvgSoftwareLayerSetter<>());
            Uri imagUri = Uri.parse(uri);
            requestBuilder
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .load(imagUri)
                    .into(imageView);

        }else {
             Glide.with(imageView.getContext()).load(uri).placeholder(R.mipmap.ic_loading).error(R.mipmap.ic_error).into(imageView);
        }




    }

}
