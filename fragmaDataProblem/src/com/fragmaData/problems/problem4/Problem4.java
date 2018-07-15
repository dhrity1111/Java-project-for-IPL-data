package com.fragmaData.problems.problem4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fragmaData.beans.Deliveries;
import com.fragmaData.problems.problem2.MatchId;
import com.fragmaData.problems.problem2.Seasons;
import com.fragmaData.problems.problem2.Teams;
import com.fragmaData.service.DeliveriesDataReaderService;

public class Problem4 {

    private Set<Integer> seasonSet = new HashSet<Integer>();
    private Set<String> teamSet = new HashSet<String>();
    public Map<Integer, List<Integer>> matchIdMap = new HashMap<Integer, List<Integer>>();

    private Map<Map<String, Integer>, Float> runRateMap;

    private Map<String, Integer> seasonTeamMap;

    private float netRunRate;

    private int season;

    private String team;

    private float overPlayed;
    private float overBowled;
    private float totalOverPlayed;
    private float totalOverBowled;
    private float totalBattingTeamRuns;
    private float totalRunsScored;
    private float totalBowlingTeamRuns;
    private float totalRunsConceded;
    private float battingTeamRate;
    private float bowlingTeamRate;

    public void problem4Solution() {

        Seasons seasons = new Seasons();
        seasonSet = seasons.getSeasons();

        Teams teams = new Teams();
        teamSet = teams.getTeams();

        MatchId matchIds = new MatchId();
        matchIdMap = matchIds.getMatchIdAndSeasonMap();

        Iterator<Integer> itSeason = seasonSet.iterator();

        while (itSeason.hasNext()) {
            season = itSeason.next();

            Iterator<String> itTeam = teamSet.iterator();

            runRateMap = new HashMap<Map<String, Integer>, Float>();

            while (itTeam.hasNext()) {

                team = itTeam.next();

                netRunRate = 0;
                overPlayed = 0;
                overBowled = 0;
                totalOverPlayed = 0;
                totalOverBowled = 0;
                totalBattingTeamRuns = 0;
                totalRunsScored = 0;
                totalBowlingTeamRuns = 0;
                totalRunsConceded = 0;
                battingTeamRate = 0;
                bowlingTeamRate = 0;

                seasonTeamMap = new HashMap<String, Integer>();
                seasonTeamMap.put(team, season);

                List<Integer> reqMatchIdsList = new ArrayList<Integer>();
                reqMatchIdsList = matchIdMap.get(season);

                Iterator<Integer> itMatchId = reqMatchIdsList.iterator();

                Set<Integer> oversPlayedSet = new HashSet<Integer>();
                Set<Integer> oversBowledSet = new HashSet<Integer>();

                while (itMatchId.hasNext()) {

                    int matchId = itMatchId.next();

                    ListIterator<Deliveries> itDeliveries = DeliveriesDataReaderService.deliveriesData.listIterator();

                    int i = 0;
                    while (itDeliveries.hasNext()) {

                        if (matchId == DeliveriesDataReaderService.deliveriesData.get(i).getMatchId()) {

                            if (team.equals(DeliveriesDataReaderService.deliveriesData.get(i).getBattingTeam())) {

                                totalBattingTeamRuns = DeliveriesDataReaderService.deliveriesData.get(i).getTotalRuns();
                                totalRunsScored = totalRunsScored + totalBattingTeamRuns;

                                oversPlayedSet.add(DeliveriesDataReaderService.deliveriesData.get(i).getOver());
                                overPlayed = Collections.max(oversPlayedSet);
                            }

                            if (team.equals(DeliveriesDataReaderService.deliveriesData.get(i).getBowlingTeam())) {

                                totalBowlingTeamRuns = DeliveriesDataReaderService.deliveriesData.get(i).getTotalRuns();
                                totalRunsConceded = totalRunsConceded + totalBowlingTeamRuns;

                                oversBowledSet.add(DeliveriesDataReaderService.deliveriesData.get(i).getOver());
                                overBowled = Collections.max(oversBowledSet);
                            }
                        }
                        i++;
                        itDeliveries.next();
                    }

                    System.out.println(overPlayed);

                    totalOverPlayed = totalOverPlayed + overPlayed;
                    totalOverBowled = totalOverBowled + overBowled;

                }

                battingTeamRate = totalRunsScored / overPlayed;
                bowlingTeamRate = totalRunsConceded / overBowled;
                netRunRate = battingTeamRate - bowlingTeamRate;

                runRateMap.put(seasonTeamMap, netRunRate);
            }

            Entry<Map<String, Integer>, Float> firstEntry = runRateMap.entrySet().iterator().next();
            Map<String, Integer> largestKey = firstEntry.getKey();
            Float largestKeyValue = firstEntry.getValue();

            for (Entry<Map<String, Integer>, Float> map : runRateMap.entrySet()) {
                Float value = map.getValue();
                if (value > largestKeyValue) {
                    largestKeyValue = value;
                    largestKey = map.getKey();
                }
            }
            System.out.println("" + largestKey + " " + largestKeyValue + "");

        }
    }
}
