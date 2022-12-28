import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 우선순위 배열 복사
        int[] print = priorities.clone();
        // 우선순위 배열 정렬
        Arrays.sort(priorities);
        
        //dq에 우선순위와 index를 함께 넣는다.
        Deque<int[]> dq = new ArrayDeque<>();
        for(int i = 0; i<print.length; i++)
            dq.addFirst(new int[] {print[i], i});
                
        // 우선순위가 높은 것 먼저 나와야 해서 정렬 배열 뒤부터 확인.
        int maxidx = print.length-1;
        while(true){
            // 프린터에서 꺼내보고
            int[] cur = dq.pollLast();
            //꺼낸 프린터의 우선순위 값이 현재 가장 높은 우선순위 값과 같은지 확인.
            if(cur[0] == priorities[maxidx]){
                //같으면 일단 꺼내고 몇번째로 나왔는지 체크하기위해 answer++
                maxidx--;
                answer++;                
                //만약 내가 원하는 location의 문서였다면 break
                if(cur[1] == location)
                    break;   
            }
            // 우선순위가 낮은 프린터라면 뒤로 넣어주기. 
            else
                dq.addFirst(cur);
        }
        
        return answer;
    }
}