package com.fragmaData.problems.problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.fragmaData.beans.Match;
import com.fragmaData.service.MatchDataReaderService;

public class MatchId {
    public Integer season;
    public List<Integer> matchIdList;

//    public Map<Integer, List<Integer>> matchIdMap;

    public Map<Integer, List<Integer>> getMatchIdAndSeasonMap() {

        Set<Integer> seasonSet = new HashSet<Integer>();
        Map<Integer, List<Integer>> matchIdMap = new HashMap<Integer, List<Integer>>();

        Seasons seasons = new Seasons();
        seasonSet = seasons.getSeasons();

        Iterator<Integer> itr = seasonSet.iterator();

        while (itr.hasNext()) {
            season = itr.next();
            int i = 0;
            matchIdList = new ArrayList<Integer>();
            ListIterator<Match> it = MatchDataReaderService.matchesData.listIterator();
            while (it.hasNext()) {

                if (it.next().getSeason() == season) {
                    matchIdList.add(MatchDataReaderService.matchesData.get(i).getMatchId());
                }
                i++;
            }
            matchIdMap.put(season, matchIdList);
//            System.out.println(matchIdMap.get(season));
        }

        return matchIdMap;
    }
}
