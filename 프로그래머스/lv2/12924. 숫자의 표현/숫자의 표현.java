import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;             // 개수를 세는 변수
        for(int i=1;i<=n;i++){      // i: 더하기 시작지점
            int temp = 0;           // 더해볼 변수
            int plus = i;           // 시작지점 저장 변수
            while(temp<n){          // n보다 작을때 까지
                temp += plus++;     // 시작지점부터 쭉 더하면서
                if(temp == n)       // n과 같아진다면
                    answer++;       // 개수세기
            }
        }
        
        return answer;              // 답안 출력
    }
}
