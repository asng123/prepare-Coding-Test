import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        int len = phone_book.length;    // phone_book의 길이
        Arrays.sort(phone_book);        // phone_book 정렬
                                        // 문자열을 정렬하면 같은 숫자끼리 붙어있게 된다.
                                        // 그점을 활용하며 비교
        for(int i=0;i<len-1;i++){                               // phone_book을 순회하며   
            String s = phone_book[i];                           // 각 문자열 길이를 체크해서
            int slen = s.length();                                  
            if(slen<=phone_book[i+1].length()){                 // 비교할 문자열과의 길이를 비교하고
                if(s.equals(phone_book[i+1].substring(0,slen))) // 길이가 긴쪽을 substring하여 같다면 
                    return false;                               // 접두어가 겹치므로 return false
            }
        }
        
        return true;
    }
}