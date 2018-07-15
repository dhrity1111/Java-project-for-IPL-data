package com.fragmaData.problems.problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.fragmaData.beans.Deliveries;
import com.fragmaData.beans.Match;
import com.fragmaData.service.DeliveriesDataReaderService;
import com.fragmaData.service.MatchDataReaderService;

public class Problem2 {

    private Set<Integer> seasonSet = new HashSet<Integer>();
    private Set<String> teamSet = new HashSet<String>();
    private Map<Integer, List<Integer>> matchIdMap = new HashMap<Integer, List<Integer>>();
    
    private int season;
    private int matchId;
    
    private int totalRuns;
    private int numberOfSix;
    private int numberOfFour;
    private int totalSix;
    private int totalFours;
    private int totalRunsScored;

    public void problem2Solution() {

        Seasons seasons = new Seasons();
        seasonSet = seasons.getSeasons();

        Teams teams = new Teams();
        teamSet = teams.getTeams();

        MatchId matchIds = new MatchId();
        matchIdMap = matchIds.getMatchIdAndSeasonMap();

        Iterator<String> itTeam = teamSet.iterator();

        while (itTeam.hasNext()) {
            String team = itTeam.next();

            Iterator<Integer> itSeason = seasonSet.iterator();

            while (itSeason.hasNext()) {
                 season = itSeason.next();
                 totalRuns = 0;
                 numberOfSix = 0;
                 numberOfFour = 0;
                 totalSix = 0;
                 totalFours = 0;
                 totalRunsScored = 0;

                List<Integer> reqMatchIdsList = new ArrayList<Integer>();
                reqMatchIdsList = matchIdMap.get(season);

                Iterator<Integer> itMatchId = reqMatchIdsList.iterator();

                while (itMatchId.hasNext()) {

                    matchId = itMatchId.next();
                    ListIterator<Deliveries> itDeliveries = DeliveriesDataReaderService.deliveriesData.listIterator();
                    
                    int i = 0;
                    while (itDeliveries.hasNext()) {

                        if (team.equals(DeliveriesDataReaderService.deliveriesData.get(i).getBattingTeam())
                                && matchId == DeliveriesDataReaderService.deliveriesData.get(i).getMatchId()) {
                            
                            totalRuns = DeliveriesDataReaderService.deliveriesData.get(i).getTotalRuns();
                            totalRunsScored = totalRunsScored + totalRuns;
                            
                            if (DeliveriesDataReaderService.deliveriesData.get(i).getBatsmanRuns() == 6)
                                numberOfSix++;
                            totalSix = numberOfSix;
                            
                            if (DeliveriesDataReaderService.deliveriesData.get(i).getBatsmanRuns() == 4)
                                numberOfFour++;
                            totalFours = numberOfFour;
                        }
                        i++;
                        itDeliveries.next();

                    }

                }
                System.out.println("*************");
                System.out.println("Season  " + season + "   Team  " + team + " Total fours " + totalFours
                        + "  Total sixes " + totalSix + " Total Runs Scored " + totalRunsScored + " ");
            }

        }
    }
}
