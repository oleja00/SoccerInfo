package com.oleeja.soccerinfo.presentation.activity_main.team;

import com.oleeja.soccerinfo.presentation.common.BaseEventListener;
import com.oleeja.soccerinfo.presentation.common.BaseView;

public interface TeamFragmentContract {
    interface View extends BaseView {
    }

    interface EventListener extends BaseEventListener{
    }

    interface EventDelegate {
    }
}