import java.io.*;
import java.util.*;

// 길이가 짧은 수열 -> 앞쪽 인덱스가 작은 수열
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = 0;
        int end = 0;
        int cur = sequence[0];
        int len = 999999999;
        while(start < sequence.length){
            // System.out.println("start : " + start + " end : " + end + " cur : " + cur + " len : " + len );
            if(cur == k){
                if(end-start+1 < len){
                    len = end-start+1;
                    answer[0] = start;
                    answer[1] = end;
                }
                if(end < sequence.length-1){
                    end++;
                    cur += sequence[end];
                }else{
                    if(start < sequence.length-1){
                        cur -= sequence[start];
                        start++;
                    }else{
                        break;
                    }
                }
            }else if(cur<k){ // cur<k
                if(end < sequence.length-1){
                    end++;
                    cur += sequence[end];
                }else{
                    break;
                }
            }else{          // cur>k
                cur -= sequence[start];
                start++;
            }     
        }
        
        
        return answer;
    }
}