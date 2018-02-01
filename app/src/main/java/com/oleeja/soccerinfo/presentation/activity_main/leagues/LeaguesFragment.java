package com.oleeja.soccerinfo.presentation.activity_main.leagues;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.databinding.FragmentLeaguesBinding;
import com.oleeja.soccerinfo.domain.leagues.model.LeagueModel;
import com.oleeja.soccerinfo.presentation.common.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class LeaguesFragment extends BaseFragment implements LeaguesFragmentContract.View {

    public static LeaguesFragment newInstance() {
        return new LeaguesFragment();
    }

    @Inject
    LeaguesPresenter mPresenter;
    private FragmentLeaguesBinding mBinding;

    private LeaguesAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_leagues, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setEventListener(mPresenter);
        mPresenter.attachView(this);
        mAdapter = new LeaguesAdapter(mPresenter);
        mBinding.rvLeagues.setLayoutManager(new GridLayoutManager(getContext(), getResources().getInteger(R.integer.column_count)));
        mBinding.rvLeagues.setAdapter(mAdapter);

        if(mPresenter.onViewStateRestored(savedInstanceState)!=null){
            mPresenter.setInfo(mPresenter.onViewStateRestored(savedInstanceState));
        }else {
            mPresenter.getLeagues(true);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    @Override
    public void showInfo(List<LeagueModel> leagueModels) {
        mAdapter.setData(leagueModels);
    }

    @Override
    public void hideRefreshUploading() {
        if(mBinding.refreshLayout.isRefreshing()){
            mBinding.refreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        hideUploading();
        mPresenter.onSaveInstanceState(outState);
    }
}
