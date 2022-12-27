import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        
        //Hash 기본 입력 받는 방법
        // for(int i = 0; i< participant.length; i++){
        //     if(map.containsKey(participant[i]))
        //        map.put(participant[i], map.get(participant[i])+1);
        //     else
        //         map.put(participant[i],1);
        // }
        
        for(int i = 0; i< participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);  
        }
        
        // 완주한 선수 제거, 동명이인 가능성 있어 -1 해준다.
        for(int i=0;i<completion.length;i++){
            map.put(completion[i],map.get(completion[i])-1);
        }
        
        // 완주 못한선수를 answer로
        for(int i=0;i<participant.length;i++){
            if(map.get(participant[i]) !=0){
                answer = participant[i];  
                break;
            }
        }
        
        return answer;
    }
}