import java.io.*;
import java.util.*;

class Solution {
    
    static int[] arr, nums, board, answer;
    static int gap;
    static boolean chk;

    public int[] solution(int n, int[] info) {
        answer = new int[11];
        
        arr = new int[11];
        nums = new int[n];
        for(int i = 0; i<11; i++){
            arr[i] = i;
        }
        
        shoot(n,info,0,0);
        
        if(!chk)
            return new int[] {-1};
    
        return answer;
    }
    
    // 중복조합으로 10자리중에 n개가 들어갈 곳을 선택-> 넣기 (void)
    public static void shoot(int n, int[] info, int start, int cnt){
        if(cnt == n){
            board = new int[11];
            for(int i =0; i<n; i++){
                board[nums[i]]++;          
            }
            
            canWin(info);
            return;
        }
        
        for(int i = start; i<11; i++){
            nums[cnt] = arr[i];
            shoot(n,info,i,cnt+1);
        }
    }
    
    // 가장 큰 점수로 이기는지 체크하는 함수 answer 배열 0번째가 -1이 이면 이기는배열 -1아니면 비교배열 (void)
    public static void canWin(int[] info){
        int infoScore = 0, boardScore = 0;
        
        for(int i = 0; i<11;i++){
            if(board[i] == 0 && info[i] == 0)
                continue;
            if(board[i] > info[i]){
                boardScore += (10-i);
            }else{
                infoScore += (10-i);
            }
        }
        
        if(boardScore > infoScore){
            if(boardScore-infoScore>gap){
                answer = board.clone();
                gap = boardScore-infoScore;
                chk = true;
            }
            if(boardScore-infoScore==gap){
                if(isAnswer()){
                    answer = board.clone();
                }
            }
        }
    }
    
    // 가장 낮은 점수를 많이 맞춘걸 check (boolean)
    public static boolean isAnswer(){
        for(int i = 10; i>=0;i--){
            if(answer[i] == 0 && board[i] == 0)
                continue;
            if(answer[i] == board[i])
                continue;
            if(answer[i] < board[i])
                return true;
            else if(answer[i]>board[i])
                return false;
        }
        
        return false;
    }
    
}