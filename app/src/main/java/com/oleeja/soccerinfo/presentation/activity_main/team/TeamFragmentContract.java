package com.oleeja.soccerinfo.presentation.activity_main.team;

import com.oleeja.soccerinfo.domain.teams.model.PlayerModel;
import com.oleeja.soccerinfo.domain.teams.model.TeamModel;
import com.oleeja.soccerinfo.presentation.common.BaseEventListener;
import com.oleeja.soccerinfo.presentation.common.BaseView;

public interface TeamFragmentContract {
    interface View extends BaseView {
        void hideRefreshUploading();

        void showInfo(TeamModel teamModel);

        void showPlayerInfo(PlayerModel player);
    }

    interface EventListener extends BaseEventListener{
        void onDetailClicked(PlayerModel model);
    }

    interface EventDelegate {
    }
}