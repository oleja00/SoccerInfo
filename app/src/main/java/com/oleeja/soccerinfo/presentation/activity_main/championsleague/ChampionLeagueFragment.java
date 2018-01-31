package com.oleeja.soccerinfo.presentation.activity_main.championsleague;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.databinding.FragmentChampionLeagueBinding;
import com.oleeja.soccerinfo.presentation.common.BaseFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class ChampionLeagueFragment extends BaseFragment implements ChampionLeagueFragmentContract.View {

    @Inject
    ChampionLeaguePresenter mPresenter;
    private FragmentChampionLeagueBinding mBinding;

    public static ChampionLeagueFragment newInstance() {
        return new ChampionLeagueFragment();
    }

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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

}
