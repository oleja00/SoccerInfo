package com.oleeja.soccerinfo.presentation.activity_main.championsleague;

import com.oleeja.soccerinfo.domain.leagues.model.ChampionGroupModel;
import com.oleeja.soccerinfo.presentation.common.BaseEventListener;
import com.oleeja.soccerinfo.presentation.common.BaseView;

import java.util.List;

public interface ChampionLeagueFragmentContract {
    interface View extends BaseView {
        void hideRefreshUploading();

        void showInfo(List<List<ChampionGroupModel>> lists);
    }

    interface EventListener extends BaseEventListener {
        void onTeamClicked(ChampionGroupModel championGroupModel);
    }

    interface EventDelegate {
        void showTeamProfile(long id);
    }
}