import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        int n = phone_book.length;
        
        // 정렬을 하면 똑같은 번호끼리 순차적으로 붙게 되어있다.
        // 따라서 앞뒤로 확인만 하면 된다.
        Arrays.sort(phone_book);
        for(int i = 0; i<n-1; i++){
            String s = phone_book[i];
            int slen = s.length();
            if(slen<=phone_book[i+1].length()){
                if(s.equals(phone_book[i+1].substring(0,slen)))
                    answer = false;
            }
        }
        
        return answer;
    }
}