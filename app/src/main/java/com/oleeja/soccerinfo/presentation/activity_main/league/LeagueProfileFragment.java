package com.oleeja.soccerinfo.presentation.activity_main.league;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.databinding.FragmentLeagueProfileBinding;
import com.oleeja.soccerinfo.domain.leagues.LeagueModel;
import com.oleeja.soccerinfo.presentation.common.BaseFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class LeagueProfileFragment extends BaseFragment implements LeagueProfileFragmentContract.View {

    public static final String LEAGUE_KEY = "league";

    public static LeagueProfileFragment newInstance(LeagueModel leagueModel) {
        LeagueProfileFragment leagueProfileFragment = new LeagueProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable(LEAGUE_KEY, leagueModel);
        leagueProfileFragment.setArguments(args);
        return leagueProfileFragment;
    }

    @Inject
    LeagueProfilePresenter mPresenter;
    private FragmentLeagueProfileBinding mBinding;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_league_profile, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setEventListener(mPresenter);
        mPresenter.attachView(this);
        mBinding.setModel(getArguments().getParcelable(LEAGUE_KEY));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

}
