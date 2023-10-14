import java.util.*;
import java.io.*;

class Solution {
    
    static int[][] tower;
    static boolean[] visited;
    static int cnt;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        tower = new int[n][n];
        for(int i = 0; i< n-1; i++){
            int a = wires[i][0]-1;
            int b = wires[i][1]-1;
            tower[a][b] = 1;
            tower[b][a] = 1;
        }
        
        for(int i = 0; i< n-1; i++){
            int a = wires[i][0]-1;
            int b = wires[i][1]-1;
            tower[a][b] = 0;
            tower[b][a] = 0;
            
            visited = new boolean[n];
            cnt = 0;
            countTower(i);
            answer = Math.min(answer, Math.abs(n-2*cnt));
            
            tower[a][b] = 1;
            tower[b][a] = 1;
        }
        
        return answer;
    }
    
    public void countTower(int cur){
        visited[cur] = true;
        cnt++;
        
        for(int i = 0;i < visited.length; i++){
            if(visited[i])
                continue;
            if(tower[cur][i] == 1)
                countTower(i);
        }
    }
}