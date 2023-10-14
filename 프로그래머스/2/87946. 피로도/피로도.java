import java.io.*;
import java.util.*;

class Solution {
    
    static int[] num;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        
        num = new int[dungeons.length];
        findOrder(0,0,dungeons,k);
        
        return answer;
    }
    
    public void findOrder(int cnt, int flag, int[][] dungeons, int k){
        if(cnt == dungeons.length){
            int temp = 0;            
            for(int i = 0; i< cnt; i++){
                int idx = num[i];
                int needPiro = dungeons[idx][0];
                int piro = dungeons[idx][1];
                
                if(k < needPiro)
                    continue;
                
                k-=piro;
                temp++;
            }
            
            answer = Math.max(temp, answer);
            return;
        }
        
        for(int i = 0; i<dungeons.length; i++){
            if((flag&(1<<i)) != 0)
                continue;
            num[cnt] = i;
            findOrder(cnt+1, flag|(1<<i), dungeons, k);
        }
    }
}