import java.util.*;
import java.io.*;

public class Solution {
    public ArrayList solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();  // return할 arraylist
        
        Deque<Integer> dq = new ArrayDeque<>(); // dq 선언
        dq.add(arr[0]);                         // dq에 첫번째 원소 넣고
        for(int i=1;i<arr.length;i++){          // arr 순회하면서 
            if(dq.peekFirst() != arr[i])        // arr값이 중복이 아닐때
                dq.addFirst(arr[i]);            // push
        }
        
        while(!dq.isEmpty())
            answer.add(dq.pollLast());          // 뒤로 빼서 answer 저장
        
        return answer;
    }
}