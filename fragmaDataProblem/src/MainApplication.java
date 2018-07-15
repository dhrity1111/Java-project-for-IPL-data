
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fragmaData.beans.Match;
import com.fragmaData.problems.problem1.Problem1;
import com.fragmaData.problems.problem2.Problem2;
import com.fragmaData.problems.problem3.Problem3;
import com.fragmaData.problems.problem4.Problem4;
import com.fragmaData.service.DeliveriesDataReaderService;
import com.fragmaData.service.MatchDataReaderService;
public class MainApplication {


    
    public static void main(String[] args) {
        MatchDataReaderService matchDataReaderService = new MatchDataReaderService();
        DeliveriesDataReaderService deliveriesDataReaderService = new DeliveriesDataReaderService();
        matchDataReaderService.readData();
        deliveriesDataReaderService.readData();
        
        Problem1 problem1 = new Problem1();
        problem1.problem1Solution();
        
        Problem2 problem2 = new Problem2();
        problem2.problem2Solution();
        
        Problem3 problem3 = new Problem3();
        problem3.problem3Solution();
        
        Problem4 problem4 = new Problem4();
        problem4.problem4Solution();
        
        

    }

    }

