package com.oleeja.soccerinfo.presentation.activity_main.table;

import android.databinding.BindingConversion;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.databinding.ItemLeagueTableBinding;
import com.oleeja.soccerinfo.domain.leagues.LeagueTableModel;
import com.oleeja.soccerinfo.presentation.common.BindingAdapter;
import com.oleeja.soccerinfo.presentation.common.BindingViewHolder;
import com.oleeja.soccerinfo.presentation.common.SortedListWrapper;

import java.util.List;

public class LeagueTableAdapter extends BindingAdapter<ItemLeagueTableBinding> {

    private SortedListWrapper<LeagueTableModel> mData;
    private LeagueTableFragmentContract.EventListener mEventListener;

    public LeagueTableAdapter(LeagueTableFragmentContract.EventListener eventListener) {
        mData = new SortedListWrapper<>(this);
        mEventListener = eventListener;
    }

    public void setData(List<LeagueTableModel> data) {
        mData.setData(data);
    }

    @Override
    protected void bindItem(BindingViewHolder<ItemLeagueTableBinding> viewHolder, int position, List<Object> payload) {
        viewHolder.getBinding().setModel(mData.get(position));
    }

    @Override
    protected int getLayoutId(int position) {
        return R.layout.item_league_table;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @BindingConversion
    public static String getStringFromNumber(long number){
        return String.valueOf(number);
    }

}
