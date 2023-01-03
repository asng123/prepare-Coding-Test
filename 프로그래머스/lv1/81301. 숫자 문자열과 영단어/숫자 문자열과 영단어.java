import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                if(sb.length() == 0){ // sb가 empty면 continue 
                    temp.append(c);
                    continue;
                }else{  // sb가 empty가 아니면
                    String num = sb.toString(); // String으로 변환해서
                    for(int i = 0;i<10;i++){   // 비교
                        if(num.equals(number[i])){
                            temp.append(i);
                            break;
                        }
                    }
                    temp.append(c);
                    sb = new StringBuilder();
                }
            }else{
                sb.append(c);
                String num = sb.toString();
                for(int i = 0;i<10;i++){   // 비교
                    if(num.equals(number[i])){
                        temp.append(i);
                        sb = new StringBuilder();
                        break;
                    }
                }
            }
        }
        answer = Integer.parseInt(temp.toString());
        return answer;
    }
}