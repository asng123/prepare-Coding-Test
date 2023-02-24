import java.io.*;
import java.util.*;

class Solution {
    
    static int[] map;    
    static int answer;
    
    public int solution(int n) {
        map = new int[n];
        
        nQueen(n,0);
        
        return answer;
    }
    
    public void nQueen(int n, int row){
        
        if(row==n){
            answer++;
            return;
        }
        
        for(int i=0;i<n;i++){
            map[row]=i;          
            if(isOk(row)){
                nQueen(n,row+1);
            }
        }        
    
    }
    
    public boolean isOk(int row){
        for(int i = 0; i < row; i++){
            if(map[row] == map[i])
                return false;
            if(Math.abs(map[row] - map[i]) == Math.abs(row-i))
                return false;
        }
        return true;
    }
    
}