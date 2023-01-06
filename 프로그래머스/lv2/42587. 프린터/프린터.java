import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        int[] print = priorities.clone();   // 우선순위 배열 복사
        Arrays.sort(priorities);            // 우선순위 배열 정렬
        
        Deque<int[]> dq = new ArrayDeque<>();
        for(int i=0;i<print.length;i++)             // 정렬하지 않은 우선순위 배열을 순회하며
            dq.addFirst(new int[] {print[i], i});   //dq에 우선순위와 index를 함께 넣는다.
                
        int maxidx = print.length-1;            // 우선순위가 높은것부터 보기 위해 배열 뒤부터 확인
        while(true){
            int[] cur = dq.pollLast();          // 프린터에서 꺼내보고
            if(cur[0] == priorities[maxidx]){   // 프린터에서 꺼낸 우선순위 값이 제일 높다면
                maxidx--;                       // 꺼내고
                answer++;                       // 몇번째로 나왔는지 체크하기 위해 answer++
                if(cur[1] == location)          // 만약 내가 원한 위치의 인쇄물이었다면
                    return answer;              // return answer     
            }
            else                                // 우선순위가 낮은 프린터라면
                dq.addFirst(cur);               // 맨뒤로 다시 넣어주기
        }
    }
}