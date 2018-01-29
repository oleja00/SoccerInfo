package com.oleeja.soccerinfo.presentation.activity_main.table;

import com.oleeja.soccerinfo.domain.leagues.LeagueTableModel;
import com.oleeja.soccerinfo.presentation.common.BaseEventListener;
import com.oleeja.soccerinfo.presentation.common.BaseView;

import java.util.List;

public interface LeagueTableFragmentContract {
    interface View extends BaseView {
        void hideRefreshUploading();

        void showInfo(List<LeagueTableModel> leagueTableModels);
    }

    interface EventListener extends BaseEventListener {
    }

    interface EventDelegate {
    }
}