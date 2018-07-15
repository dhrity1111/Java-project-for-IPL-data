package com.fragmaData.problems.problem2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

import com.fragmaData.beans.Match;
import com.fragmaData.service.MatchDataReaderService;

public class Seasons {

    public Set<Integer> seasonSet = new HashSet<Integer>();

    public Set<Integer> getSeasons() {

        ListIterator<Match> it = MatchDataReaderService.matchesData.listIterator();

        while (it.hasNext()) {

            seasonSet.add(it.next().getSeason());

        }
        return seasonSet;

    }
}
