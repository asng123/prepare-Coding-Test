import java.util.*;
import java.io.*;

// 속도만큼 진행시키면서 풀이
class Solution {
    public ArrayList solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
      
        int idx = 0;                    // 순회할 idx
        int size = progresses.length;   // idx limit
        while(idx < size){                              // idx가 size를 넘지않을때 까지
            for(int i=idx;i<size;i++)                   // progresses를 순회하며
                progresses[i] += speeds[i];             // speeds만큼 진행
            
            boolean chk = true;
            int cnt = 0;
            while(chk){                                 // chk가 true일 동안
                if(idx<size&&progresses[idx] >= 100){   // 범위내에서 진행율이 100% 이상인것을
                    cnt++;                              // 세주고
                    idx++;                              // idx를 증가시킨다.
                }else{                                  // 진행률이 100%가 아니면 연속적으로 넣어줘야하므로
                    chk = false;                        // 중단시키기위해 chk를 false로 바꾼다.
                }
            }
            
            if(cnt>=1)              // cnt가 1 이상이면
                answer.add(cnt);    // 한번에 배포되는 양 answer에 입력
        }
        
        return answer;
    }
}
