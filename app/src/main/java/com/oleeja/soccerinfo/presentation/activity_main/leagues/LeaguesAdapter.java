package com.oleeja.soccerinfo.presentation.activity_main.leagues;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.databinding.ItemLeagueBinding;
import com.oleeja.soccerinfo.domain.leagues.LeagueModel;
import com.oleeja.soccerinfo.presentation.common.BindingAdapter;
import com.oleeja.soccerinfo.presentation.common.BindingViewHolder;
import com.oleeja.soccerinfo.presentation.common.SortedListWrapper;

import java.util.List;

public class LeaguesAdapter extends BindingAdapter<ItemLeagueBinding> {

    private SortedListWrapper<LeagueModel> mData;

    public LeaguesAdapter() {
        mData = new SortedListWrapper<LeagueModel>(this);
    }

    public void setData(List<com.oleeja.soccerinfo.domain.leagues.LeagueModel> data) {
        mData.setData(data);
    }

    @Override
    protected void bindItem(BindingViewHolder<ItemLeagueBinding> viewHolder, int position, List<Object> payload) {
        viewHolder.getBinding().setModel(mData.get(position));
    }

    @Override
    protected int getLayoutId(int position) {
        return R.layout.item_league;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
