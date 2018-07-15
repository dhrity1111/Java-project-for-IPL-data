package com.fragmaData.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fragmaData.beans.Match;
import com.fragmaData.problems.problem1.Problem1;

public class MatchDataReaderService implements DataReaderServiceInterface {
    
//    private String[] matchData;
//
//    public MatchDataReaderService(String[] matchData) {
//        this.matchData = matchData;
//    }
    
    public static List<Match> matchesData = new ArrayList<Match>();
    
    public void readData(){
        
        String csvFile = "/home/divya/Desktop/matches.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int skip = 0;
//        MatchDataReaderService matchDataReaderService = new MatchDataReaderService(); 
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                if(skip == 0){
                    skip++;
                    continue;
                }
                // using comma as separator here
                String[] match = line.split(cvsSplitBy);
                this.storeData(match);
//                System.out.println(match[9]);
                
            }
        }
            

         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

       
        
//        System.out.println("**********");
//        System.out.println(MatchDataReaderService.matchesData.get(9).getCity());
//        System.out.println("**********");
            
    }
    
    
    public void storeData(String[] data) {
        Match match = new Match();
        
        int data0 = Integer.parseInt(data[0]);
        int data1 = Integer.parseInt(data[1]);
        
        match.setMatchId(data0);
        match.setSeason(data1);
        match.setCity(data[2]);
        match.setDate(data[3]);
        match.setTeam1(data[4]);
        match.setTeam2(data[5]);
        match.setTossWinner(data[6]);
        match.setTossDecision(data[7]);
        match.setResult(data[8]);
        match.setWinner(data[9]);
        
        matchesData.add(match);
        
//        return matchesData;
        
//       System.out.println("**********");
//       System.out.println(matchesData.get(0).getCity());
//       System.out.println("**********");
    }
    
}
