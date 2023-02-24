import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int idx1 = -1, idx2 = -1;
        boolean chk = false;
        
        boolean[] chkArr = new boolean[goal.length];
        G: for(int i = 0; i< goal.length; i++){
            boolean check = false;
            
            for(int j = 0; j < cards1.length; j++){
                if(goal[i].equals(cards1[j])){
                    if(idx1<=j && (j-idx1) == 1){
                        idx1 = j;
                        chkArr[i] = true;
                        check = true;
                        break;
                    }else{
                        answer="No";
                        break G;
                    }
                }else{
                    chk = true;
                }
            }
            
                for(int j = 0; j < cards2.length; j++){
                    if(goal[i].equals(cards2[j])){
                        if(idx2<=j && j-idx2 == 1){
                            idx2 = j;
                            chkArr[i] = true;
                            break;
                        }else{
                            answer="No";
                            break G;
                        }
                    }else{
                        chk = true;
                    }
                }
        }
        
        for(int i = 0; i<goal.length; i++){
            if(!chkArr[i]){
                answer="No";
            }
        }
        return answer;
    }
}