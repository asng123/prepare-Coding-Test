import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n) {
        // 박스 개수
        int num = 0;
        for(int i=1; i<=n; i++)
            num += i;
        
        // 삼각형 배열
        int[] triangle = new int[num];
        // 이차원 형태로 넣을 배열
        int[][] temp = new int[n][n];
        
        //idx좌표
        int x = -1;
        int y = 0;
        //넣을 값
        int input = 1;
        
        // 중요:이차원 배열에서 아래로 n만큼 가로로 n-1만큼 대각선위로 n-2만큼,,, 반복해서 들어간다!
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(i%3 == 0){
                    x++;
                }else if(i%3 == 1){
                    y++;
                }else{
                    x--;
                    y--;
                }
                
                temp[x][y] = input++;
            }
        }
        
        int idx = 0;
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                if(temp[i][j] == 0)
                    break;
                triangle[idx++] = temp[i][j];
            }
        }
        return triangle;
    }
    
}