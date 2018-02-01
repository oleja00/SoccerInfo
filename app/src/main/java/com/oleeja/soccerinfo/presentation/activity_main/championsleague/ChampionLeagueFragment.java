package com.oleeja.soccerinfo.presentation.activity_main.championsleague;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.databinding.FragmentChampionLeagueBinding;
import com.oleeja.soccerinfo.domain.leagues.ChampionGroupModel;
import com.oleeja.soccerinfo.presentation.common.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class ChampionLeagueFragment extends BaseFragment implements ChampionLeagueFragmentContract.View {

    public static final String ID_KEY = "id";

    public static ChampionLeagueFragment newInstance(long id) {
        ChampionLeagueFragment leagueTableFragment = new ChampionLeagueFragment();
        Bundle args = new Bundle();
        args.putLong(ID_KEY, id);
        leagueTableFragment.setArguments(args);
        return leagueTableFragment;
    }

    @Inject
    ChampionLeaguePresenter mPresenter;
    private FragmentChampionLeagueBinding mBinding;

    private ChampionLeagueAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_champion_league, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setEventListener(mPresenter);
        mPresenter.attachView(this);

        mAdapter = new ChampionLeagueAdapter(mPresenter);
        mBinding.rvChampionLeague.setLayoutManager(new GridLayoutManager(getContext(), getResources().getInteger(R.integer.column_count)));
        mBinding.rvChampionLeague.setAdapter(mAdapter);

        mPresenter.setId(getArguments().getLong(ID_KEY));
        if(mPresenter.onViewStateRestored(savedInstanceState)!=null){
            mPresenter.setInfo(mPresenter.onViewStateRestored(savedInstanceState));
        }else {
            mPresenter.getChampionTable(true);
        }
    }

    @Override
    public void showInfo(List<List<ChampionGroupModel>> lists) {
        mAdapter.setData(lists);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    @Override
    public void hideRefreshUploading() {
        if(mBinding.refreshLayout.isRefreshing()){
            mBinding.refreshLayout.setRefreshing(false);
        }
    }

}
