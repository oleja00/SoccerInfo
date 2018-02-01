package com.oleeja.soccerinfo.presentation.activity_main.team;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.databinding.ItemPlayerBinding;
import com.oleeja.soccerinfo.domain.teams.model.PlayerModel;
import com.oleeja.soccerinfo.presentation.common.BindingAdapter;
import com.oleeja.soccerinfo.presentation.common.BindingViewHolder;
import com.oleeja.soccerinfo.presentation.common.SortedListWrapper;

import java.util.List;

public class PlayerAdapter extends BindingAdapter<ItemPlayerBinding> {

    private SortedListWrapper<PlayerModel> mData;
    private TeamFragmentContract.EventListener mEventListener;

    public PlayerAdapter(TeamFragmentContract.EventListener eventListener) {
        mData = new SortedListWrapper<>(this);
        mEventListener = eventListener;
    }

    public void setData(List<PlayerModel> data) {
        mData.setData(data);
    }

    @Override
    protected void bindItem(BindingViewHolder<ItemPlayerBinding> viewHolder, int position, List<Object> payload) {
        viewHolder.getBinding().setModel(mData.get(position));
        viewHolder.getBinding().setEventListener(mEventListener);
    }

    @Override
    protected int getLayoutId(int position) {
        return R.layout.item_player;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
