import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 9999;
        // s의 길이
        int len = s.length();
        // s길이가 1이면 1
        if(len==1)
            return 1;
        // s길이가 2이면 2
        if(len==2)
            return 2;
        
        // char 배열로
        char[] str = s.toCharArray();
        // 문자열 나눌 sb
        StringBuilder sb = new StringBuilder();
        // 문자열을 나눌 단위 1~s/2
        for(int i=1;i<=len/2;i++){
            int idx = 0;
            // 나눈 문자열을 담을 temp 
            ArrayList<String> temp = new ArrayList<>();
            // 단위만큼 잘라서 temp에 넣기
            while(idx<len){
                for(int j=0;j<i;j++){
                    if(idx>=len)
                        break;
                    sb.append(str[idx++]);
                }
                // System.out.println(sb.toString());
                temp.add(sb.toString());
                sb.setLength(0);
            }
            // temp를 앞에서 부터 순회하면서
            // 뒤에 같은 문자열이라면 cnt++
            // 뒤에 다른 문자열이라면 cnt값에 따라 cnt넣고 문자열 넣고 or 문자열만 넣고
            // answer 최솟값 갱신해주고
            int cnt = 1;
            StringBuilder ans = new StringBuilder();
            for(int j=0;j<temp.size()-1;j++){
                if(temp.get(j).equals(temp.get(j+1))){
                    cnt++;
                }else{
                    if(cnt == 1){
                        ans.append(temp.get(j));
                        cnt = 1;
                    }else{
                        ans.append(cnt).append(temp.get(j));
                        cnt = 1;
                    }
                }
            }
            if(cnt==1)
                ans.append(temp.get(temp.size()-1));
            else
                ans.append(cnt).append(temp.get(temp.size()-1));
            
            answer = Math.min(ans.length(), answer);
        }
        
        
        return answer;
    }
}