package com.oleeja.soccerinfo.presentation.activity_main.table;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.databinding.FragmentLeagueTableBinding;
import com.oleeja.soccerinfo.presentation.common.BaseFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class LeagueTableFragment extends BaseFragment implements LeagueTableFragmentContract.View {

    public static final String ID_KEY = "id";

    public static LeagueTableFragment newInstance(long id) {
        LeagueTableFragment leagueTableFragment = new LeagueTableFragment();
        Bundle args = new Bundle();
        args.putLong(ID_KEY, id);
        leagueTableFragment.setArguments(args);
        return leagueTableFragment;
    }

    @Inject
    LeagueTablePresenter mPresenter;
    private FragmentLeagueTableBinding mBinding;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_league_table, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setEventListener(mPresenter);
        mPresenter.attachView(this);
       // mPresenter.getLeagueTable(getArguments().getLong(ID_KEY));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

}
