package com.fragmaData.problems.problem1;

import com.fragmaData.beans.Match;
import com.fragmaData.problems.problem2.Seasons;
import com.fragmaData.problems.problem2.Teams;
import com.fragmaData.service.MatchDataReaderService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Problem1 {

    private Set<Integer> seasonSet = new HashSet<Integer>();
    private Map<Map<String, Integer>, Integer> tossWinnerMap;
    private Set<String> teamSet = new HashSet<String>();
    private Map<String, Integer> seasonTeamMap;

    private int count;
    private int countDecision;
    private int season;
    private String team;

    public void problem1Solution() {

        Teams teams = new Teams();
        teamSet = teams.getTeams();

        Seasons seasons = new Seasons();
        seasonSet = seasons.getSeasons();

        Iterator<Integer> itSeason = seasonSet.iterator();

        while (itSeason.hasNext()) {
            season = itSeason.next();

            tossWinnerMap = new HashMap<Map<String, Integer>, Integer>();
            if (season == 2016 || season == 2017) {


                Iterator<String> itTeam = teamSet.iterator();

                while (itTeam.hasNext()) {
                    team = itTeam.next();

                    count = 0;
                    countDecision = 0;

                    seasonTeamMap = new HashMap<String, Integer>();
                    seasonTeamMap.put(team, season);

                    ListIterator<Match> it = MatchDataReaderService.matchesData.listIterator();
                    int i = 0;
                    while (it.hasNext()) {

                        if ((MatchDataReaderService.matchesData.get(i).getSeason() == season)
                                && (MatchDataReaderService.matchesData.get(i).getTossWinner().equals(team))) {

                            if (MatchDataReaderService.matchesData.get(i).getTossDecision().equals("field"))
                                count++;

                            countDecision = count;
                        }
                        it.next();
                        i++;

                    }

                    tossWinnerMap.put(seasonTeamMap, countDecision);
                   
                }

                

                for (int j = 0; j < 4; j++) {
                    
                    Entry<Map<String, Integer>, Integer> firstEntry = tossWinnerMap.entrySet().iterator().next();
                    Map<String, Integer> largestKey = firstEntry.getKey();
                    Integer largestKeyValue = firstEntry.getValue();

                    for (Entry<Map<String, Integer>, Integer> map : tossWinnerMap.entrySet()) {
                        Integer value = map.getValue();
                        if (value > largestKeyValue) {
                            largestKeyValue = value;
                            largestKey = map.getKey();
                        }
                    }
                    System.out.println("" + largestKey + " " + largestKeyValue + "");
                    tossWinnerMap.remove(largestKey);
                }

            }
        }
    }
}