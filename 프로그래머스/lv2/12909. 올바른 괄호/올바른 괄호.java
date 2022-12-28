import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                st.add(s.charAt(i));
            }else{
                if(st.size()>0){
                    st.pop();
                }else{
                    answer = false;
                    break;
                }
            }
        }
        if(st.size()>0)
            answer = false;

        return answer;
    }
}