package com.oleeja.soccerinfo.presentation.activity_main.league;

import com.oleeja.soccerinfo.domain.leagues.LeagueModel;
import com.oleeja.soccerinfo.presentation.common.BaseEventListener;
import com.oleeja.soccerinfo.presentation.common.BaseView;

public interface LeagueProfileFragmentContract {
    interface View extends BaseView{
        void showInfo(LeagueModel leagueModel);

        void hideRefreshUploading();
    }

    interface EventListener extends BaseEventListener {
    }

    interface EventDelegate {
    }
}