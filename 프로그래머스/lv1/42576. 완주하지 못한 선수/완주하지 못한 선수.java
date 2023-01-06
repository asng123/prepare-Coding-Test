import java.util.*;
import java.io.*;

// HashMap
// put, get, getOrDefault, remove(key), values(), keySet(), containskey, containsValue
// size, clear, isEmpty
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = ""; // 답을 제출할 answer
        
        HashMap<String,Integer> map = new HashMap<>();  // 마라톤 경기에 참여하는 인원     
        for(int i = 0; i< participant.length; i++){     // 참여인원 순회하면서 넣기
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);  //★*100
        }
        
        for(int i=0;i<completion.length;i++){                   // 완주자 순회
            map.put(completion[i],map.get(completion[i])-1);    // 완주자 인원 빼주기
        }
        
        for(int i=0;i<participant.length;i++){  // map을 순회하면서
            if(map.get(participant[i]) !=0){    // 남은 인원이 있다면
                answer = participant[i];        // answer에 넣기
                break;
            }
        }
        
        return answer;
    }
}
