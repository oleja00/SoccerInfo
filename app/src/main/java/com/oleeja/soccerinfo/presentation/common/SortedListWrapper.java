package com.oleeja.soccerinfo.presentation.common;

import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.Callback;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.widget.RecyclerView.Adapter;

import java.util.ArrayList;
import java.util.List;

public class SortedListWrapper<T extends SortedEntity> {
    private ArrayList<T> mData = new ArrayList<>();
    private final Adapter mAdapter;

    public SortedListWrapper(Adapter adapter) {
        this.mAdapter = adapter;
    }

    public void setData(List<T> data) {
        DiffResult diffResult = DiffUtil.calculateDiff(new SortedListWrapper.SortedCallback(mData, data));
        this.mData.clear();
        this.mData.addAll(data);
        diffResult.dispatchUpdatesTo(this.mAdapter);
    }

    public void addData(List<T> data) {
        ArrayList<T> newData = new ArrayList<>(mData.size() + data.size());
        newData.addAll(this.mData);
        newData.addAll(data);
        this.setData(newData);
    }

    public T get(int position) {
        return mData.get(position);
    }

    public int size() {
        return this.mData.size();
    }

    private static class SortedCallback<T extends SortedEntity> extends Callback {
        private List<T> mOldData;
        private List<T> mNewData;

        private SortedCallback(List<T> oldData, List<T> newData) {
            this.mOldData = oldData;
            this.mNewData = newData;
        }

        public int getOldListSize() {
            return this.mOldData.size();
        }

        public int getNewListSize() {
            return this.mNewData.size();
        }

        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return (mOldData.get(oldItemPosition)).areItemsTheSame(mNewData.get(newItemPosition));
        }

        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return (mOldData.get(oldItemPosition)).areContentsTheSame(mNewData.get(newItemPosition));
        }
    }
}
