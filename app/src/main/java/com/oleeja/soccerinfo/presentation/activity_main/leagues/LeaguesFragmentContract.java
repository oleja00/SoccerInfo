package com.oleeja.soccerinfo.presentation.activity_main.leagues;

import com.oleeja.soccerinfo.domain.leagues.LeagueModel;
import com.oleeja.soccerinfo.presentation.common.BaseEventListener;
import com.oleeja.soccerinfo.presentation.common.BaseView;

import java.util.List;

public interface LeaguesFragmentContract {
    interface View extends BaseView {
        void showInfo(List<LeagueModel> leagueModels);

        void hideRefreshUploading();
    }

    interface EventListener extends BaseEventListener {
        void onLeagueClicked(LeagueModel model);
    }

    interface EventDelegate {
        void showLeagueProfile(LeagueModel model);
    }
}