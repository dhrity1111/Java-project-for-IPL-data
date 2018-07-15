# Java-project-for-IPL-data
In this project I have used IPL matches data from year 2008-17, stored and processed it according 4 problems.

The problem mentioned below revolves around IPL dataset. The dataset contains 2 files
which are as follows

1.DELIVERIES.csv          
MATCH_ID              
INNING             
BATTING_TEAM            
BOWLING_TEAM              
OVER              
BALL                          
BATSMAN                
BOWLER                   
WIDE_RUNS                      
BYE_RUNS                       
LEGBYE_RUNS         
NOBALL_RUNS       
PENALTY_RUNS        
BATSMAN_RUNS          
EXTRA_RUNS          
TOTAL_RUNS            

2.MATCHES.csv
MATCH_ID           
SEASON         
CITY         
DATE         
TEAM1          
TEAM2          
TOSS_WINNER        
TOSS_DECISION        
RESULT        
WINNER             


The four problems are as follows

1. Top 4 teams which elected to field first after winning toss in 2016 and 2017.
Output Expected:  YEAR TEAM COUNT

2. List total number of fours, sixes, total score with respect to team and year.
Output Expected: YEAR TEAM_NAME FOURS_COUNT SIXES_COUNT TOTAL_SCORE

3. Top 10 best economy rate bowler with respect to year who bowled at least 10
overs (LEGBYE_RUNS and BYE_RUNS should not be considered for Total Runs Given
by a bowler)
Economy = (Total Runs Given/Overs bowled)
Output Expected: YEAR PLAYER ECONOMY

4. Find the team name which has Highest Net Run Rate with respect to year.
Net Run Rate = (Total Runs Scored / Total Overs Faced) – (Total Runs
Conceded /Total Overs Bowled)
