import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1;i<=n;i++){
            int temp = 0;
            int plus = i;
            while(temp<n){
                temp += plus++;
                if(temp == n)
                    answer++;
            }
        }
        
        return answer;
    }
}