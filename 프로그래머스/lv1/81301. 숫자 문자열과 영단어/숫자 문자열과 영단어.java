import java.io.*;
import java.util.*;

// ***String.replaceAll()을 활용하여 풀 수 있음.***
class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){   // c가 숫자일때
                if(sb.length() == 0){   // sb가 empty면
                    temp.append(c);     // 답인 숫자 c를 temp에 넣고 continue
                    continue;
                }else{                          // sb가 empty가 아니면
                    String num = sb.toString(); // String으로 변환해서
                    for(int i = 0;i<10;i++){    // 비교 후 맞는 숫자를 temp에 넣기
                        if(num.equals(number[i])){
                            temp.append(i);
                            break;
                        }
                    }
                    temp.append(c);  // 그다음 이어지는 정답 숫자 temp에 넣기
                    sb.setLength(0); // *** StringBuilder 초기화 방법 ***
                }
            }
            else{               // c가 숫자가 아닐때
                sb.append(c);   // 문자를 sb에 넣고          
                String num = sb.toString(); // sixseven처럼 이어지는 문자열이 있으니 넣을 때 마다 체크
                for(int i = 0;i<10;i++){    // 비교해서 답을 temp에 넣기
                    if(num.equals(number[i])){
                        temp.append(i);
                        sb.setLength(0); // *** StringBuilder 초기화 방법 ***
                        break;
                    }
                }
            }
        }
        
        answer = Integer.parseInt(temp.toString()); // 답 추출
        return answer;
    }
}
