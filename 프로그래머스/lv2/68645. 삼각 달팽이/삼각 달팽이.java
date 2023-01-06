import java.io.*;
import java.util.*;

// 삼각 달팽이를 이차원 형태로 넣는 idea가 중요
class Solution {
    public int[] solution(int n) {      
        int[] triangle = new int[n*(n+1)/2];    // 삼각형 배열
        int[][] temp = new int[n][n];           // ★이차원 형태로 넣을 배열★
        
        int x = -1;     // x좌표
        int y = 0;      // y좌표
        int input = 1;  // input 값
        
        // 이차원 배열에서 아래로 n만큼 가로로 n-1만큼 대각선위로 n-2만큼,,, 반복해서 들어간다!
        for(int i=0;i<n;i++){           // i가 0 ~ n-1
            for(int j=i;j<n;j++){       // j가 i만큼 개수가 줄어든다
                if(i%3 == 0){           // 처음에는 아래로
                    x++;
                }else if(i%3 == 1){     // 두번째로 오른쪽
                    y++;
                }else{                  // 세번째로 대각선 위로 이동하면서
                    x--;
                    y--;
                }
                
                temp[x][y] = input++;   // 값을 넣어준다.
            }
        }
        
        int idx = 0;
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){               // temp 배열을 순회하며 
                if(temp[i][j] == 0)             // 직각삼각형으로 들어가므로 temp[i][j]가 0이면 
                    break;                      // break 해주고
                triangle[idx++] = temp[i][j];   // 1차원 배열로 변환한다.
            }
        }
        
        return triangle;
    }
    
}