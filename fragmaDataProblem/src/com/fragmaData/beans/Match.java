package com.fragmaData.beans;

public class Match {

    private int matchId;
    private int season;
    private String city;
    private String date;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String result;
    private String winner;
    
    public int getMatchId() {
        return matchId;
    }
    public int getSeason() {
        return season;
    }
    public String getCity() {
        return city;
    }
    public String getDate() {
        return date;
    }
    public String getTeam1() {
        return team1;
    }
    public String getTeam2() {
        return team2;
    }
    public String getTossWinner() {
        return tossWinner;
    }
    public String getTossDecision() {
        return tossDecision;
    }
    public String getResult() {
        return result;
    }
    public String getWinner() {
        return winner;
    }
    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
    public void setSeason(int season) {
        this.season = season;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTeam1(String team1) {
        this.team1 = team1;
    }
    public void setTeam2(String team2) {
        this.team2 = team2;
    }
    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }
    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public void setWinner(String winner) {
        this.winner = winner;
    }
    
    
}
