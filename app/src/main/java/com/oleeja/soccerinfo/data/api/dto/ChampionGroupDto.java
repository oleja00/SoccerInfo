package com.oleeja.soccerinfo.data.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleja on 31.01.2018.
 */

public class ChampionGroupDto {

    @SerializedName("group")
    public String group;

    @SerializedName("rank")
    public long rank;

    @SerializedName("team")
    public String team;

    @SerializedName("teamId")
    public long teamId;

    @SerializedName("playedGames")
    public long playedGames;

    @SerializedName("crestURI")
    public String crestURI;

    @SerializedName("points")
    public long points;

    @SerializedName("goals")
    public long goals;

    @SerializedName("goalsAgainst")
    public long goalsAgainst;

    @SerializedName("goalDifference")
    public long goalDifference;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public long getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(long playedGames) {
        this.playedGames = playedGames;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public long getGoals() {
        return goals;
    }

    public void setGoals(long goals) {
        this.goals = goals;
    }

    public long getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(long goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public long getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(long goalDifference) {
        this.goalDifference = goalDifference;
    }

}

