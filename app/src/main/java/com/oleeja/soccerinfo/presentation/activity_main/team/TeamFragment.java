package com.oleeja.soccerinfo.presentation.activity_main.team;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;


import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.databinding.DialogPlayerDetailBinding;
import com.oleeja.soccerinfo.databinding.FragmentTeamBinding;
import com.oleeja.soccerinfo.domain.leagues.model.LeagueModel;
import com.oleeja.soccerinfo.domain.teams.model.PlayerModel;
import com.oleeja.soccerinfo.domain.teams.model.TeamModel;
import com.oleeja.soccerinfo.presentation.activity_main.league.LeagueProfileFragment;
import com.oleeja.soccerinfo.presentation.common.BaseFragment;

import dagger.android.support.AndroidSupportInjection;

import javax.inject.Inject;

public class TeamFragment extends BaseFragment implements TeamFragmentContract.View {

    public static final String TEAM_KEY = "team";

    public static TeamFragment newInstance(long id) {
        TeamFragment teamFragment = new TeamFragment();
        Bundle args = new Bundle();
        args.putLong(TEAM_KEY, id);
        teamFragment.setArguments(args);
        return teamFragment;
    }

    @Inject
    TeamPresenter mPresenter;
    private FragmentTeamBinding mBinding;
    private PlayerAdapter mAdapter;

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

        mAdapter = new PlayerAdapter(mPresenter);
        mBinding.rvPlayers.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.rvPlayers.setAdapter(mAdapter);

        mPresenter.setTeamId(getArguments().getLong(TEAM_KEY, 0));
        if (mPresenter.onViewStateRestored(savedInstanceState) != null) {
            mPresenter.setInfo(mPresenter.onViewStateRestored(savedInstanceState));
        } else {
            mPresenter.getTeam(true);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    @Override
    public void showInfo(TeamModel teamModel) {
        mBinding.setTeam(teamModel);
        mAdapter.setData(teamModel.playerModels());
    }

    @Override
    public void showPlayerInfo(PlayerModel player) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        DialogPlayerDetailBinding binding = DataBindingUtil.inflate(inflater, R.layout.dialog_player_detail, null, false);
        binding.setModel(player);
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                .setView(binding.getRoot())
                .setCancelable(false)
                .setTitle(R.string.player_details)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.dismiss())
                .create();
        alertDialog.show();
        doKeepDialog(alertDialog);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSaveInstanceState(outState);
    }

    @Override
    public void hideRefreshUploading() {
        if (mBinding.refreshLayout.isRefreshing()) {
            mBinding.refreshLayout.setRefreshing(false);
        }
    }

    private static void doKeepDialog(Dialog dialog){
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
    }
}
