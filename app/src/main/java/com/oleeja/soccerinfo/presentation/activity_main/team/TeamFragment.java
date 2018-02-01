package com.oleeja.soccerinfo.presentation.activity_main.team;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.databinding.FragmentTeamBinding;
import com.oleeja.soccerinfo.presentation.common.BaseFragment;

import dagger.android.support.AndroidSupportInjection;

import javax.inject.Inject;

public class TeamFragment extends BaseFragment implements TeamFragmentContract.View {

    @Inject
    TeamPresenter mPresenter;
    private FragmentTeamBinding mBinding;

    public static TeamFragment newInstance() {
        return new TeamFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_team, container, false);
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
