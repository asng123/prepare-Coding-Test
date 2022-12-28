import java.util.*;
import java.io.*;

class Solution {
    public ArrayList solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
      
        int idx = 0;
        int size = progresses.length;
        while(idx < size){
            //매일 speeds 만큼 진행시키기
            for(int i=idx;i<size;i++){
                progresses[i] += speeds[i];
            }
            
            boolean chk = true;
            int cnt = 0;
            // 연속적으로 진도율 100이상인것들 cnt하기
            while(chk){
                if(idx<size&&progresses[idx] >= 100){
                    idx++;
                    cnt++;
                }else{
                    chk = false;
                }
            }
            // 한번에 배포되는거 answer에 넣기
            if(cnt>=1){
                answer.add(cnt);
            }
        }
        
        return answer;
    }
}