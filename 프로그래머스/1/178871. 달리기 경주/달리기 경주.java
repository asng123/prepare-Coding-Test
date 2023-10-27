import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> map = new HashMap<>();
        
        String[] answer = players.clone();
        
        int playersLen = players.length;
        for(int i = 0; i<playersLen; i++){
            map.put(players[i],i);
        }
        
        int callLen = callings.length;
        for(int i = 0;i<callLen; i++){
            int idx = map.get(callings[i]);            
            answer[idx-1] = answer[idx];
            answer[idx] = players[idx-1];
            players[idx-1] = answer[idx-1];
            players[idx] = answer[idx];
            map.put(answer[idx-1], idx-1);
            map.put(answer[idx], idx);
            
        }
        
        return answer;
    }
}