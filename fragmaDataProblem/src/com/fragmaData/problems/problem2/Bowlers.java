package com.fragmaData.problems.problem2;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import com.fragmaData.beans.Deliveries;
import com.fragmaData.beans.Match;
import com.fragmaData.service.DeliveriesDataReaderService;
import com.fragmaData.service.MatchDataReaderService;

public class Bowlers {
    
    


public Set<String> bowlerSet = new HashSet<String>();

public Set<String> getBowlers() {

    ListIterator<Deliveries> it = DeliveriesDataReaderService.deliveriesData.listIterator();

    while (it.hasNext()) {

        bowlerSet.add(it.next().getBowlerName());

    }
    return bowlerSet;

}
}