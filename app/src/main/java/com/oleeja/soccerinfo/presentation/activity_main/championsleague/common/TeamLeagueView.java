package com.oleeja.soccerinfo.presentation.activity_main.championsleague.common;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oleeja.soccerinfo.R;

/**
 * Created by Oleja on 01.02.2018.
 */

public class TeamLeagueView extends LinearLayout {
    private Context mContext;
    private ImageView ivPicture;
    private TextView tvText;

    public TeamLeagueView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public TeamLeagueView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public TeamLeagueView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        View v = LayoutInflater.from(mContext).inflate(R.layout.view_team_league, this);
        ivPicture = v.findViewById(R.id.ivLogo);
        tvText = v.findViewById(R.id.tvName);
    }

    public ImageView getIvPicture() {
        return ivPicture;
    }

    public TextView getTvText() {
        return tvText;
    }
}
