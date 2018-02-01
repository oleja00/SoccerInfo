package com.oleeja.soccerinfo.presentation.activity_main.championsleague;

import android.widget.LinearLayout;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.databinding.ItemChampionGroupBinding;
import com.oleeja.soccerinfo.domain.leagues.ChampionGroupModel;
import com.oleeja.soccerinfo.presentation.activity_main.championsleague.common.TeamLeagueView;
import com.oleeja.soccerinfo.presentation.common.BindingAdapter;
import com.oleeja.soccerinfo.presentation.common.BindingViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ChampionLeagueAdapter extends BindingAdapter<ItemChampionGroupBinding> {

    private List<List<ChampionGroupModel>> mData;
    private ChampionLeagueFragmentContract.EventListener mEventListener;

    public ChampionLeagueAdapter(ChampionLeagueFragmentContract.EventListener eventListener) {
        mData = new ArrayList<>();
        mEventListener = eventListener;
    }

    public void setData(List<List<ChampionGroupModel>> data) {
        mData.clear();
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    protected void bindItem(BindingViewHolder<ItemChampionGroupBinding> viewHolder, int position, List<Object> payload) {
        viewHolder.getBinding().setModel(mData.get(position));
        viewHolder.getBinding().setEventListener(mEventListener);
    }

    @Override
    protected int getLayoutId(int position) {
        return R.layout.item_champion_group;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @android.databinding.BindingAdapter({"group", "click"})
    public static void setGroup(LinearLayout layout, List<ChampionGroupModel> models, ChampionLeagueFragmentContract.EventListener mEventListener) {
        if (layout.getChildCount() > 0) {
            layout.removeAllViews();
        }

        for (ChampionGroupModel model : models) {
            TeamLeagueView teamLeagueView = new TeamLeagueView(layout.getContext());
            teamLeagueView.getTvText().setText(model.team());
            BindingAdapter.setImage(teamLeagueView.getIvPicture(), model.crestURI());
            teamLeagueView.setOnClickListener(view -> mEventListener.onTeamClicked(model));
            layout.addView(teamLeagueView);
        }

    }
}
