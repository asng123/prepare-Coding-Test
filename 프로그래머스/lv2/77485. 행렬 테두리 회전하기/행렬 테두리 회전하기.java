import java.util.*;
import java.io.*;

class Solution {
    
    static ArrayList<Integer> answer;
    static int[][] arr;
    
    public ArrayList solution(int rows, int columns, int[][] queries) {
    
        answer = new ArrayList<>();
        
        // arr 값 넣기
        int x = 1;
        arr = new int[rows][columns];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                arr[i][j] = x++;
            }
        }
        
        
        for(int i = 0; i<queries.length; i++){
            moveArr(queries[i]);
            // for(int j = 0; j<rows; j++){
            //     System.out.println(Arrays.toString(arr[j]));
            // }
            // System.out.println("-----------------");
        }
        return answer;
    }
    
    public void moveArr(int[] query){
        int x1 = query[0]-1;
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;
        
        // 0. min 갱신을 위해 값 저장
        int min = arr[x1][y2];
        
        // 1. (x1,y2) 저장
        int temp = arr[x1][y2];
        
        // 2. (x1,y2-1) ~ (x1,y1) 까지 오른쪽으로 당기기
        for(int i = y2-1; i>=y1; i--){
            arr[x1][i+1] = arr[x1][i];
            min = Math.min(arr[x1][i], min);
        }
        
        // 3. (x1+1,y1) ~ (x2,y1) 까지 위로 당기기
        for(int i = x1+1; i<=x2; i++){
            arr[i-1][y1] = arr[i][y1];
            min = Math.min(arr[i][y1], min);
        }
        
        // 4. (x2,y1+1) ~ (x2,y2) 까지 왼쪽으로 당기기
        for(int i = y1+1; i<=y2; i++){
            arr[x2][i-1] = arr[x2][i];
            min = Math.min(arr[x2][i], min);
        }
        
        // 5. (x2-1,y2) ~ (x1,y2) 까지 아래로 당기기
        for(int i = x2-1; i>=x1; i--){
            arr[i+1][y2] = arr[i][y2];
            min = Math.min(arr[i][y2], min);
        }
        
        // 6. temp를 (x1+1,y2)에 넣기
        arr[x1+1][y2] = temp;
        
        answer.add(min);
    }
}