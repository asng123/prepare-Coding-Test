import java.io.*;
import java.util.*;

// a->b 아이기스
// b 요격 최소 미사일
// 2차원 공간
// x축 평행 직선 미사일 (s,e)
// B나라는 y축 향해 미사일 관통가능 실수인 x좌표도 가능
// targets [시작][끝]
// 개구간,, 개구간 겹치는걸 어떻게 확인할까?
// 길이 x, 좌표로,, 대신  끝 - 0.1 로 봐보자,,
// 일단 정렬 해야할듯,,
// (1,4) (4,5) (3,7) (4,8) (5,12) (11,13) (10,14)
// 3.9보다 작은 시작찾기,, 탐색은 안되는데,,
// (1,4) (3,7) (4,5) (4,8) (5,12) (10,14) (11,13)
// 4.9는? 
// 6.9 이것도 완탐이다
// 3.9시작 포격 포격 4.9로 변경 포격 포격 11.9로 변경 포격 포격 포격
// 이거다
class Solution {
    public int solution(int[][] targets) {       
        Arrays.sort(targets,(o1,o2)-> { return o1[1]-o2[1]; });
        
        double x = (double)targets[0][1] - 0.1;
        int answer = 1;
        
        for(int[] t: targets){
            if((double)t[0]>x){
                x = (double)t[1]-0.1;
                answer++;
            }
        }
        
        
        return answer;
    }
}