import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String,Integer> map = new HashMap<>();  // 종류와 개수를 담을 HashMap
        for(int i = 0; i < clothes.length; i++)         // clothes를 순회하며 map에 put
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);  
        
        for(int a:map.values()) // 종류별로 어떤것을 입던가 안입던가 2가지 경우가 있어
            answer *= (a+1);    // 종류의 개수 + 1을 곱해준다.
        
        return answer-1;        // 그후 아무것도 안입은 경우를 제외시키고 답을 return 한다
    }
}