import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 9999;
        
        int len = s.length();   // s의 길이
        if(len==1)              // s길이가 1이면 1
            return 1;
        if(len==2)              // s길이가 2이면 2
            return 2;
        
        char[] str = s.toCharArray();           // char 배열로
        StringBuilder cut = new StringBuilder(); // 문자열 나눌 cut
        
        for(int i=1;i<=len/2;i++){                      // 문자열을 나눌 단위 1~s/2
            int idx = 0;                                // str을 순회할 idx
            ArrayList<String> temp = new ArrayList<>(); // 나눈 문자열을 담을 temp 
            
            while(idx<len){                 // 단위만큼 잘라서 temp에 넣기
                for(int j=0;j<i;j++){       // 0부터 단위까지 반복하면서 cut하기
                    cut.append(str[idx++]);
                    if(idx>=len)            // 단, str배열을 순회하는 idx가 len 보다 길어지면 break
                        break;
                }
                
                temp.add(cut.toString());   // 자른만큼 temp에 넣기
                cut.setLength(0);           // cut 초기화
            }
            
            int cnt = 1;                                // 중복되는 문자열의 개수를 세어주는 변수
            StringBuilder ans = new StringBuilder();    // 단위에 따라 압축된 문자열을 담을 ans  
            for(int j=0;j<temp.size()-1;j++){                   // temp를 앞에서 부터 순회하면서
                if(temp.get(j).equals(temp.get(j+1))){          // 앞뒤의 문자열이 같다면
                    cnt++;                                      // 개수 세어주기
                }else{                                          // 앞뒤 문자열이 다르다면
                    if(cnt == 1){                               // cnt가 1일때. 즉, 중복되는 문자열이 없을때
                        ans.append(temp.get(j));                // ans에 그냥 넣어주기
                        cnt = 1;                                // cnt 초기화
                    }else{                                      // cnt가 1이 아닐때. 즉, 중복되는 문자열이 있을때
                        ans.append(cnt).append(temp.get(j));    // ans에 cnt값과 문자열 넣어주기
                        cnt = 1;                                // cnt 초기화
                    }
                }
            }
            
            if(cnt==1)                                              // 남는 문자열 넣기
                ans.append(temp.get(temp.size()-1));                // cnt가 1일때는 맨뒤에 값만 넣어주면 된다.
            else
                ans.append(cnt).append(temp.get(temp.size()-1));    // cnt가 1보다 클때는 cnt값과 맨뒤에 값을 넣어준다.
            
            answer = Math.min(ans.length(), answer);                // 최솟값 갱신
        }
        
        return answer;
    }
}
