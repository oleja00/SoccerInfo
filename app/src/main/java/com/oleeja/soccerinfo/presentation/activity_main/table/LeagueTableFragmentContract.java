package com.oleeja.soccerinfo.presentation.activity_main.table;

import com.oleeja.soccerinfo.domain.leagues.model.LeagueTableModel;
import com.oleeja.soccerinfo.presentation.common.BaseEventListener;
import com.oleeja.soccerinfo.presentation.common.BaseView;

import java.util.List;

public interface LeagueTableFragmentContract {
    interface View extends BaseView {
        void hideRefreshUploading();

        void showInfo(List<LeagueTableModel> leagueTableModels);
    }

    interface EventListener extends BaseEventListener {
        void onTeamClicked(LeagueTableModel leagueTableModel);
    }

    interface EventDelegate {
        void showTeamProfile(long id);
    }
}