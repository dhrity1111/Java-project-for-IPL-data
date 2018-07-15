package com.fragmaData.problems.problem2;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import com.fragmaData.beans.Match;
import com.fragmaData.service.MatchDataReaderService;

public class Teams {
    
    public Set<String> teamSet = new HashSet<String>();

    public Set<String> getTeams() {

        ListIterator<Match> it = MatchDataReaderService.matchesData.listIterator();

        while (it.hasNext()) {

            teamSet.add(it.next().getTeam1());

        }
        return teamSet;

    }

}
