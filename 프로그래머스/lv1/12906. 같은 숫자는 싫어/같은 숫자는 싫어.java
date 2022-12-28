import java.util.*;
import java.io.*;

public class Solution {
    public ArrayList solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        
        //dq에 첫번째 원소 넣고
        dq.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            // dq들어가는쪽 값이 연속으로 중복된 값이 아닐때 add
            if(dq.peekFirst() != arr[i])
                dq.addFirst(arr[i]);
        }
        
        while(!dq.isEmpty())
            answer.add(dq.pollLast());     
        
        return answer;
    }
}